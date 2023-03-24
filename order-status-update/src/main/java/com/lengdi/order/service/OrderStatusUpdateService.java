package com.lengdi.order.service;

import com.lengdi.sdmall.entity.Orders;

/**
 * Date:2023/03/11/ 18:33
 * Author:leng
 * Description:
 */
public interface OrderStatusUpdateService {

    public int updateStatus(Orders order);

}