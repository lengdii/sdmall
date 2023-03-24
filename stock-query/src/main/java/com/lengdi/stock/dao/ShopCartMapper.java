package com.lengdi.stock.dao;

import com.lengdi.sdmall.entity.ShoppingCart;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * Date:2023/03/10/ 23:09
 * Author:leng
 * Description:
 */
@Repository
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {

    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> list);

}
