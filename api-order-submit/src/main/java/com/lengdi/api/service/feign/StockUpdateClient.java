package com.lengdi.api.service.feign;

import com.lengdi.api.service.feign.fallback.StockUpdateClientFallback;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * Date:2023/03/11/ 15:36
 * Author:leng
 * Description:
 */
@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);

}