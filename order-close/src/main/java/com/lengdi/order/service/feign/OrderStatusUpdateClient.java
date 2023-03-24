package com.lengdi.order.service.feign;

import com.lengdi.sdmall.beans.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("order-status-update")
public interface OrderStatusUpdateClient {

    @PutMapping("/order/status/update")
    public int update(Orders order);

}
