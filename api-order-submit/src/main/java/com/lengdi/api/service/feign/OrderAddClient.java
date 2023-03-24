package com.lengdi.api.service.feign;

import com.lengdi.api.service.feign.fallback.OrderAddClientFallback;
import com.lengdi.sdmall.beans.Orders;
import com.lengdi.sdmall.beans.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Date:2023/03/11/ 15:36
 * Author:leng
 * Description:
 */
@FeignClient(value = "order-add",fallback = OrderAddClientFallback.class)
public interface OrderAddClient {

    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(Orders order, @RequestParam("cids") String cids);

}

