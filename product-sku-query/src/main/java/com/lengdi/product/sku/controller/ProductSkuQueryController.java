package com.lengdi.product.sku.controller;

import com.lengdi.product.sku.service.ProductSkuQueryService;
import com.lengdi.sdmall.entity.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/11/ 19:24
 * Author:leng
 * Description:
 */
@RestController
public class ProductSkuQueryController {

    @Autowired
    private ProductSkuQueryService productSkuQueryService;

    @GetMapping("/product/sku/query")
    public ProductSku query(String skuId){
        return productSkuQueryService.queryProductSku(skuId);
    }


}

