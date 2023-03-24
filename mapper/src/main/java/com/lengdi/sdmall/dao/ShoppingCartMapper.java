package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.ShoppingCart;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import com.lengdi.sdmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {

    public List<ShoppingCartVO> selectShopcartByUserId(int userId);


    public int updateCartNumByCartId(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);

    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> cids);


}