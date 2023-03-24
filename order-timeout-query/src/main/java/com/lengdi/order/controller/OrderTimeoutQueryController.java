package com.lengdi.order.controller;

import com.lengdi.order.service.OrderTimeoutQueryService;
import com.lengdi.sdmall.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/11/ 18:23
 * Author:leng
 * Description:
 */
@RestController
public class OrderTimeoutQueryController {

    @Autowired
    private OrderTimeoutQueryService orderTimeoutQueryService;

    @GetMapping("/order/query/timeout")
    public List<Orders> query(){
        //查询并返回超时未支付的订单
        return orderTimeoutQueryService.listOrders();
    }


}