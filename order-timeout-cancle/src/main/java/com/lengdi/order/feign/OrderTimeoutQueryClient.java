package com.lengdi.order.feign;

import com.lengdi.order.feign.fallback.OrderTimeoutQueryClientFallback;
import com.lengdi.sdmall.beans.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Date:2023/03/11/ 20:11
 * Author:leng
 * Description:
 */
@FeignClient(value = "order-timeout-query",fallback = OrderTimeoutQueryClientFallback.class)
public interface OrderTimeoutQueryClient {

    @GetMapping("/order/query/timeout")
    public List<Orders> query();
}
