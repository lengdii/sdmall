package com.lengdi.controller;

import com.github.wxpay.sdk.WXPay;
import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.service.job.MyPayConfig;
import com.lengdi.sdmall.service.OrderService;
import com.lengdi.sdmall.vo.ResStatus;
import com.lengdi.sdmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Date:2023/02/17/ 18:22
 * Author:leng
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "提供订单相关的操作接口",tags = "订单管理")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResultVO add(String cids, @RequestBody Orders order){
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderService.addOrder(cids, order);
            if(orderInfo!=null){
                String orderId = orderInfo.get("orderId");
                //设置当前订单信息
                HashMap<String,String> data = new HashMap<>();
                data.put("body",orderInfo.get("productNames"));            //商品描述
                data.put("out_trade_no",orderId);                   //使用当前用户订单的作为当前支付交易交易号
                data.put("fee_type","CNY");                      //支付币种
//                data.put("total_fee",order.getActualAmount()*100+"");          // 支付金额
                data.put("total_fee","1");                      // 支付金额
                data.put("trade_type","NATIVE");                //交易类型
//                data.put("notify_url","http://lengdi.free.idcfengye.com/pay/callback");          //设置支付完成时的回调方法接口
                data.put("notify_url","http://8.130.77.18:8080/pay/callback");            //设置支付完成时的回调方法接口

                //发送请求，获取响应
                //微信支付：申请支付链接
                WXPay wxPay = new WXPay(new MyPayConfig());
                Map<String, String> resp = wxPay.unifiedOrder(data);
                orderInfo.put("payUrl",resp.get("code_url"));

                resultVO = new ResultVO(ResStatus.OK,"订单提交成功！",orderInfo);
            }else {
                resultVO = new ResultVO(ResStatus.NO,"订单提交失败！",null);
            }

        } catch (SQLException e) {
            resultVO = new ResultVO(ResStatus.NO,"订单提交失败！",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    @GetMapping("/status/{oid}")
    public ResultVO getOrderStatus(@PathVariable("oid") String orderId,@RequestHeader("token")String token){
        ResultVO resultVO = orderService.getOrderById(orderId);
        return resultVO;
    }

    @GetMapping("/list")
    @ApiOperation("订单查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户登录ID", dataType = "string", paramType = "query",  required = true),
            @ApiImplicitParam(name = "status", value = "订单状态", dataType = "string", paramType = "query",  required = false),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", paramType = "query",  required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int", paramType = "query",  required = true)
    })
    public ResultVO list(@RequestHeader("token")String token,
                         String userId,String status,int pageNum,int limit){
        ResultVO resultVO = orderService.listOrders(userId, status, pageNum, limit);
        return  resultVO;
    }
}
