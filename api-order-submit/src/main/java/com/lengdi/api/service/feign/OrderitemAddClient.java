package com.lengdi.api.service.feign;

import com.lengdi.api.service.feign.fallback.OrderitemAddClientFallback;
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
@FeignClient(value = "orderitem-add",fallback = OrderitemAddClientFallback.class)
public interface OrderitemAddClient {

    @PostMapping("/item/save")
    public int addOrderItem(List<ShoppingCartVO> list, @RequestParam("orderId") String orderId);

}
