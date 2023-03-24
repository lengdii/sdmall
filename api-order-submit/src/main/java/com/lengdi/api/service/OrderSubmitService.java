package com.lengdi.api.service;

import com.lengdi.sdmall.beans.Orders;

import java.util.Map;

/**
 * Date:2023/03/11/ 15:33
 * Author:leng
 * Description:
 */
public interface OrderSubmitService {

    public Map<String, String> addOrder(String cids, Orders order);
}
