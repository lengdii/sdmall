package com.lengdi.orderitem.controller;

import com.lengdi.orderitem.service.OrderItemQueryService;
import com.lengdi.sdmall.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/11/ 18:58
 * Author:leng
 * Description:
 */
@RestController
public class OrderItemQueryController {

    @Autowired
    private OrderItemQueryService orderItemQueryService;

    @GetMapping("/orderitem/query")
    public List<OrderItem> query(String orderId){
        List<OrderItem> orderItems = orderItemQueryService.queryOrderItem(orderId);
        return orderItems;
    }

}