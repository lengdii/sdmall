package com.lengdi.order.service.impl;

import com.lengdi.sdmall.entity.Orders;
import com.lengdi.order.dao.OrdersMapper;
import com.lengdi.order.service.OrderTimeoutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Date:2023/03/11/ 18:26
 * Author:leng
 * Description:
 */
@Service
public class OrderTimeoutServiceImpl implements OrderTimeoutQueryService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> listOrders() {
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        criteria.andLessThan("createTime", time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        return orders;
    }
}
