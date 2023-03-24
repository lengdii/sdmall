package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.OrderAddClient;
import com.lengdi.sdmall.beans.Orders;
import com.lengdi.sdmall.beans.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Date:2023/03/11/ 15:37
 * Author:leng
 * Description:
 */
@Component
public class OrderAddClientFallback implements OrderAddClient {
    @Override
    public List<ShoppingCartVO> saveOrder(Orders order, String cids) {
        System.out.println("order-add-------服务降级");
        return null;
    }
}
