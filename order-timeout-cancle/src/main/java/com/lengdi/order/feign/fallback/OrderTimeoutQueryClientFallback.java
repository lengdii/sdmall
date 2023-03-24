package com.lengdi.order.feign.fallback;

import com.lengdi.order.feign.OrderTimeoutQueryClient;
import com.lengdi.sdmall.beans.Orders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2023/03/11/ 20:12
 * Author:leng
 * Description:
 */
@Component
public class OrderTimeoutQueryClientFallback implements OrderTimeoutQueryClient {
    @Override
    public List<Orders> query() {
        System.out.println("order-timeout-query ~~~~~~~~~~ 服务降级");
        return new ArrayList<>();
    }
}
