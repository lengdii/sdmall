package com.lengdi.order.service;

import com.lengdi.sdmall.entity.Orders;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Date:2023/03/11/ 15:03
 * Author:leng
 * Description:
 */
public interface OrderAddService {

    public List<ShoppingCartVO> save(@RequestBody Orders orders, String cids);

}
