package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.entity.OrdersVO;
import com.lengdi.sdmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper extends GeneralDAO<Orders> {

    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);

}