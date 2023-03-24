package com.lengdi.sdmall.service;

import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.vo.ResultVO;

import java.sql.SQLException;
import java.util.Map;

/**
 * Date:2023/02/16/ 23:03
 * Author:leng
 * Description:
 */
public interface OrderService {

    public Map<String,String> addOrder(String cids, Orders order) throws SQLException;

    public int updateOrderStatus(String orderId,String status);

    public ResultVO getOrderById(String orderId);

    public void closeOrder(String orderId);

    public ResultVO listOrders(String userId,String status,int pageNum,int limit);
}
