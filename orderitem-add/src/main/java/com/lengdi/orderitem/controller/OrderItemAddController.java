package com.lengdi.orderitem.controller;

import com.lengdi.orderitem.service.OrderItemAddService;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/03/16/ 22:16
 * Author:leng
 * Description:
 */
@RestController
public class OrderItemAddController {

    @Autowired
    private OrderItemAddService orderItemAddService;

    @PostMapping("/item/save")
    public int addOrderItem(@RequestBody List<ShoppingCartVO> list, String orderId){
        return orderItemAddService.save(list,orderId);
    }

}