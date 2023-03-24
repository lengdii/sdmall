package com.lengdi.order.service;

import com.github.wxpay.sdk.WXPay;
import com.lengdi.order.config.MyPayConfig;
import com.lengdi.order.feign.OrderCloseClient;
import com.lengdi.order.feign.OrderQueryByIdClient;
import com.lengdi.order.feign.OrderStatusUpdateClient;
import com.lengdi.order.feign.OrderTimeoutQueryClient;
import com.lengdi.sdmall.beans.Orders;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Date:2023/03/11/ 20:08
 * Author:leng
 * Description:
 */
@Service
@RabbitListener(queues = "q2")
public class ReveiveMsgFromMQService {

    @Autowired
    private OrderTimeoutQueryClient orderTimeoutQueryClient;

    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderCloseClient orderCloseClient;

    @Autowired
    private OrderQueryByIdClient orderQueryByIdClient;

    @RabbitHandler
    public void checkAndCancleOrder(String orderId, Channel channel, Message message) throws IOException {
        try {
            //1.根据订单编号查询当前订单信息
            Orders order = orderQueryByIdClient.query(orderId);
            if( order != null && "1".equals( order.getStatus() )){
                HashMap<String, String> params = new HashMap<>();
                params.put("out_trade_no", order.getOrderId());
                Map<String, String> resp = wxPay.orderQuery(params);
                if("SUCCESS".equalsIgnoreCase(resp.get("trade_state"))){
                    //2.1 如果订单已经支付，则修改订单状态为"代发货/已支付"  status = 2
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");
                    //调用 order-status-update 服务，修改订单状态为2
                    int j = orderStatusUpdateClient.update(updateOrder);
                }else if("NOTPAY".equalsIgnoreCase(resp.get("trade_state"))){
                    //2.2 如果确实未支付 则取消订单：
                    //  a.向微信支付平台发送请求，关闭当前订单的支付链接
                    Map<String, String> map = wxPay.closeOrder(params);
                    // b.关闭订单
                    int k = orderCloseClient.close(order.getOrderId(),1);
                }
            }
            channel.basicAck( message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack( message.getMessageProperties().getDeliveryTag(),false,true);
        }
    }
}

