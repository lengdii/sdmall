package com.lengdi.order.controller;

import com.lengdi.order.service.OrderCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/11/ 18:40
 * Author:leng
 * Description:
 */
@RestController
public class OrderCloseController {
    @Autowired
    private OrderCloseService orderCloseService;

    @GetMapping("/order/close")
    public int close(String orderId,int closeType){
        int i = orderCloseService.closeOrder(orderId,closeType);
        return i;
    }


}