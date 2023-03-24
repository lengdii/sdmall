package com.lengdi.sdmall.service;

import com.lengdi.sdmall.entity.ShoppingCart;
import com.lengdi.sdmall.vo.ResultVO;

/**
 * Date:2023/02/13/ 17:20
 * Author:leng
 * Description:
 */
public interface ShoppingCartService {

    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateCartNum(int cartId,int cartNum);

    public ResultVO listShoppingCartsByCids(String cids);

}
