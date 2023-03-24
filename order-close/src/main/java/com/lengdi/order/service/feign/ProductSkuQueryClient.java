package com.lengdi.order.service.feign;

import com.lengdi.order.service.feign.fallback.ProductSkuQueryClientFallback;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-sku-query",fallback = ProductSkuQueryClientFallback.class)
public interface ProductSkuQueryClient {

    @GetMapping("/product/sku/query")
    public ProductSku query(@RequestParam("skuId") String skuId);

}
