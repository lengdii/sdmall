package com.lengdi.shopcart.dao;

import com.lengdi.sdmall.entity.ShoppingCart;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Date:2023/03/11/ 0:08
 * Author:leng
 * Description:
 */
@Repository
public interface ShoppingCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
}
