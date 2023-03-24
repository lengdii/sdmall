package com.lengdi.orderitem.service;

import com.lengdi.sdmall.entity.ShoppingCartVO;

import java.util.List;

/**
 * Date:2023/03/16/ 22:16
 * Author:leng
 * Description:
 */
public interface OrderItemAddService {

    public int save(List<ShoppingCartVO> list, String orderId);
}

