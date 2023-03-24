package com.lengdi.order.service;

/**
 * Date:2023/03/11/ 18:40
 * Author:leng
 * Description:
 */
public interface OrderCloseService {

    public int closeOrder(String orderId,int closeType);

}