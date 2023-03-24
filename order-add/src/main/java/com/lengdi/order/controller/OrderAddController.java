package com.lengdi.order.controller;

import com.lengdi.order.service.OrderAddService;
import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/11/ 14:59
 * Author:leng
 * Description:
 */
@RestController
public class OrderAddController {

    @Autowired
    private OrderAddService orderAddService;


    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(@RequestBody Orders order, String cids){
        System.out.println("--------------------order-add");
        List<ShoppingCartVO> list = orderAddService.save(order, cids);
        System.out.println(list);
        return list;
    }

}
