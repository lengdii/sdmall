package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.OrderItem;
import com.lengdi.sdmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper extends GeneralDAO<OrderItem> {

    public List<OrderItem> listOrderItemsByOrderId(String orderId);

}