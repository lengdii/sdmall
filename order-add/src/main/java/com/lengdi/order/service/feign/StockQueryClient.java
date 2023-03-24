package com.lengdi.order.service.feign;

import com.lengdi.order.service.feign.fallback.StockQueryClientFallback;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Date:2023/03/11/ 15:10
 * Author:leng
 * Description:
 */
@FeignClient(value = "stock-query",fallback = StockQueryClientFallback.class)
public interface StockQueryClient {

    @GetMapping("/stock/query")
    public List<ShoppingCartVO> query(@RequestParam("cids") String cids);

}