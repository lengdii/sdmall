package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.OrderitemAddClient;
import com.lengdi.sdmall.beans.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Date:2023/03/11/ 15:37
 * Author:leng
 * Description:
 */
@Component
public class OrderitemAddClientFallback implements OrderitemAddClient {

    @Override
    public int addOrderItem(List<ShoppingCartVO> list, String orderId) {
        System.out.println("oderitem-add-------服务降级");
        return 0;
    }
}
