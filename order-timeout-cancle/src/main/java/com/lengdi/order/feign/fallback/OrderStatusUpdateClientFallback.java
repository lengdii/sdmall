package com.lengdi.order.feign.fallback;

import com.lengdi.order.feign.OrderStatusUpdateClient;
import com.lengdi.sdmall.beans.Orders;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/11/ 20:12
 * Author:leng
 * Description:
 */
@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {
    @Override
    public int update(Orders order) {
        System.out.println("order-status-update  ~~~~~~  服务降级");
        return 0;
    }
}
