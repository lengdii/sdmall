package com.lengdi.order.feign.fallback;

import com.lengdi.order.feign.OrderCloseClient;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/11/ 20:12
 * Author:leng
 * Description:
 */
@Component
public class OrderCloseClientFallback implements OrderCloseClient {
    @Override
    public int close(String orderId, int closeType) {
        System.out.println("order-close ~~~~~~~~~~ 服务降级");
        return 0;
    }
}
