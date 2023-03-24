package com.lengdi.stock.controller;

import com.lengdi.sdmall.entity.Product;
import com.lengdi.sdmall.entity.ProductSku;
import com.lengdi.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/10/ 23:58
 * Author:leng
 * Description:
 */
@RestController
public class StockUpdateController {

    @Autowired
    private StockUpdateService stockUpdateService;

    @PutMapping("/stock/update")
    public int update(@RequestBody List<ProductSku> skus){
        return stockUpdateService.updateStock(skus);
    }

}
