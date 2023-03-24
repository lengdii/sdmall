package com.lengdi.stock.service.impl;

import com.lengdi.sdmall.entity.ShoppingCartVO;
import com.lengdi.stock.dao.ShopCartMapper;
import com.lengdi.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2023/03/10/ 23:18
 * Author:leng
 * Description:
 */
@Service
public class StockQueryServiceImpl implements StockQueryService {
    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<ShoppingCartVO> selectShopcartByCids(String cids) {
        //1，2，3，8
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shopCartMapper.selectShopcartByCids(cidsList);
        return list;
    }
}
