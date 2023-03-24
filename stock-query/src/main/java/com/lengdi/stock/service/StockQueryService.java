package com.lengdi.stock.service;

import com.lengdi.sdmall.entity.ShoppingCartVO;

import java.util.List;

/**
 * Date:2023/03/10/ 23:17
 * Author:leng
 * Description:
 */
public interface StockQueryService {

    public List<ShoppingCartVO> selectShopcartByCids(String cids);



}
