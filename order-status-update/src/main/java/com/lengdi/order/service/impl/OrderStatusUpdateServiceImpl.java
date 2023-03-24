package com.lengdi.order.service.impl;

import com.lengdi.order.dao.OrdersMapper;
import com.lengdi.order.service.OrderStatusUpdateService;
import com.lengdi.sdmall.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date:2023/03/11/ 18:33
 * Author:leng
 * Description:
 */
@Service
public class OrderStatusUpdateServiceImpl implements OrderStatusUpdateService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int updateStatus(Orders order) {
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i;
    }
}