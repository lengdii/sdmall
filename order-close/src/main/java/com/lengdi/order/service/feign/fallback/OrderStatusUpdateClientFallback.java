package com.lengdi.order.service.feign.fallback;

import com.lengdi.order.service.feign.OrderStatusUpdateClient;
import com.lengdi.sdmall.beans.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {

    @Override
    public int update(Orders order) {
        System.out.println("order-status-update ~~~~~ 服务降级");
        return 0;
    }
}
