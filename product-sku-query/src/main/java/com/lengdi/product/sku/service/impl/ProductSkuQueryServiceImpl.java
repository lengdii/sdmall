package com.lengdi.product.sku.service.impl;

import com.lengdi.product.sku.dao.ProductSkuMapper;
import com.lengdi.product.sku.service.ProductSkuQueryService;
import com.lengdi.sdmall.entity.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date:2023/03/11/ 19:25
 * Author:leng
 * Description:
 */
@Service
public class ProductSkuQueryServiceImpl implements ProductSkuQueryService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public ProductSku queryProductSku(String skuId) {
        return productSkuMapper.selectByPrimaryKey(skuId);
    }
}