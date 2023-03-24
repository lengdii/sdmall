package com.lengdi.orderitem.service.impl;

import com.lengdi.orderitem.dao.OrderItemMapper;
import com.lengdi.orderitem.service.OrderItemQueryService;
import com.lengdi.sdmall.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Date:2023/03/11/ 18:59
 * Author:leng
 * Description:
 */
@Service
public class OrderItemQueryServiceImpl implements OrderItemQueryService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> queryOrderItem(String orderId) {
        Example example1 = new Example(OrderItem.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orderId", orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
        return orderItems;
    }
}