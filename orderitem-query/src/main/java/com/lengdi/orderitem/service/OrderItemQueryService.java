package com.lengdi.orderitem.service;

import com.lengdi.sdmall.entity.OrderItem;

import java.util.List;

/**
 * Date:2023/03/11/ 18:58
 * Author:leng
 * Description:
 */
public interface OrderItemQueryService {

    public List<OrderItem> queryOrderItem(String orderId);

}

