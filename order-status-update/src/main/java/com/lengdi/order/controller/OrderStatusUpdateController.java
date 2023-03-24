package com.lengdi.order.controller;

import com.lengdi.order.service.OrderStatusUpdateService;
import com.lengdi.sdmall.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/11/ 18:31
 * Author:leng
 * Description:
 */
@RestController
public class OrderStatusUpdateController {

    @Autowired
    private OrderStatusUpdateService orderStatusUpdateService;

    @PutMapping("/order/status/update")
    public int update(@RequestBody Orders order){
        return orderStatusUpdateService.updateStatus(order);
    }

}