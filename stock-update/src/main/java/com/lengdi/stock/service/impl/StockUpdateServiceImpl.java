package com.lengdi.stock.service.impl;

import com.lengdi.sdmall.entity.ProductSku;
import com.lengdi.stock.dao.ProductSkuMapper;
import com.lengdi.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date:2023/03/11/ 0:02
 * Author:leng
 * Description:
 */
@Service
public class StockUpdateServiceImpl implements StockUpdateService {
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public int updateStock(List<ProductSku> skus) {
        int j = 1;
        for (ProductSku productSku: skus) {
            int i = productSkuMapper.updateByPrimaryKeySelective(productSku);
            j *=i;
        }
        return j;
    }
}
