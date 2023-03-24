package com.lengdi.order.service.feign;


import com.lengdi.order.service.feign.fallback.StockUpdateClientFallback;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);

}
