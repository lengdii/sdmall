package com.lengdi.order.service.feign;

import com.lengdi.sdmall.beans.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("orderitem-query")
public interface OrderItemQueryClient {

    @GetMapping("/orderitem/query")
    public List<OrderItem> query(@RequestParam("orderId") String orderId);

}
