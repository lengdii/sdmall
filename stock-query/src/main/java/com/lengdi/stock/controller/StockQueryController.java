package com.lengdi.stock.controller;

import com.lengdi.sdmall.entity.ShoppingCart;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import com.lengdi.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/10/ 23:23
 * Author:leng
 * Description:
 */
@RestController
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @GetMapping("stock/query")
    public List<ShoppingCartVO> query(String cids){
        List<ShoppingCartVO> list = stockQueryService.selectShopcartByCids(cids);
        return list;
    }

}
