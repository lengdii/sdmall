package com.lengdi.order.service.feign.fallback;

import com.lengdi.order.service.feign.ProductSkuQueryClient;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.stereotype.Component;

@Component
public class ProductSkuQueryClientFallback implements ProductSkuQueryClient {

    @Override
    public ProductSku query(String skuId) {
        System.out.println("product-sku-query ~~~~~~~  服务降级");
        return null;
    }
}
