package com.lengdi.order.dao;

import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.entity.Orders;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Date:2023/03/11/ 18:24
 * Author:leng
 * Description:
 */
@Repository
public interface OrdersMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}
