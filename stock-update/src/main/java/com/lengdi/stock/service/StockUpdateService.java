package com.lengdi.stock.service;

import com.lengdi.sdmall.entity.ProductSku;

import java.util.List;

/**
 * Date:2023/03/11/ 0:00
 * Author:leng
 * Description:
 */
public interface StockUpdateService {

    public int updateStock(List<ProductSku> skus);
}
