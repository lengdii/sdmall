package com.lengdi.api.service.impl;

import com.lengdi.api.service.OrderSubmitService;
import com.lengdi.api.service.feign.OrderAddClient;
import com.lengdi.api.service.feign.OrderitemAddClient;
import com.lengdi.api.service.feign.ShopcartDelClient;
import com.lengdi.api.service.feign.StockUpdateClient;
import com.lengdi.sdmall.beans.Orders;
import com.lengdi.sdmall.beans.ProductSku;
import com.lengdi.sdmall.beans.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Date:2023/03/11/ 15:34
 * Author:leng
 * Description:
 */

@Service
public class OrderSubmitServiceImpl implements OrderSubmitService {

    @Autowired
    private OrderAddClient orderAddClient;
    @Autowired
    private OrderitemAddClient orderitemAddClient;
    @Autowired
    private StockUpdateClient stockUpdateClient;
    @Autowired
    private ShopcartDelClient shopcartDelClient;

    @Override
    public Map<String, String> addOrder(String cids, Orders order) {
        Map<String, String> map = null;
        //1.保存订单（校验库存）  order-add
        //生成订单编号
        String orderId = UUID.randomUUID().toString().replace("-","");
        order.setOrderId(orderId);
        List<ShoppingCartVO> carts = orderAddClient.saveOrder(order, cids);

        if(carts != null){
            //2.保存订单快照   orderitem-add
            int i = orderitemAddClient.addOrderItem(carts, orderId);

            if(i > 0 ){
                //3.修改库存  stock-update
                // 将购物车中的商品 及要修改的库存 封装到 ProductSku中
                List<ProductSku> skus = new ArrayList<>();
                for (ShoppingCartVO sc : carts) {
                    String skuId = sc.getSkuId();
                    int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    skus.add(productSku);
                }
                //调用服务
                int j = stockUpdateClient.update(skus);

                //4.删除购物车  shopcart-del
                if(j>0){
                    int k = shopcartDelClient.delete(cids);
                    if (k > 0 ){
                        map = new HashMap<>();
                        map.put("orderId", orderId);
                        String str = "";
                        for (int index = 0; index < carts.size(); index++) {
                            str += carts.get(index).getSkuName();
                            str = index==carts.size()-1?str:str+",";
                        }
                        map.put("productNames", str);
                    }
                }
            }
        }
        return map;
    }
}

