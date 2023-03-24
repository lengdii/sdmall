package com.lengdi.orderitem.dao;

import com.lengdi.sdmall.entity.OrderItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Date:2023/03/16/ 22:15
 * Author:leng
 * Description:
 */
@Repository
public interface OrderItemMapper extends Mapper<OrderItem>, MySqlMapper<OrderItem> {
}