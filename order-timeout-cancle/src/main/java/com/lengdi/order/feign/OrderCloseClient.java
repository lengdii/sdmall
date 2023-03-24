package com.lengdi.order.feign;

import com.lengdi.order.feign.fallback.OrderCloseClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date:2023/03/11/ 20:11
 * Author:leng
 * Description:
 */
@FeignClient(value = "order-close",fallback = OrderCloseClientFallback.class)
public interface OrderCloseClient {

    @GetMapping("/order/close")
    public int close(@RequestParam("orderId") String orderId,
                     @RequestParam("closeType") int closeType);
}
