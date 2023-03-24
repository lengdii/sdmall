package com.lengdi.order.service.feign.fallback;

import com.lengdi.order.service.feign.StockQueryClient;
import com.lengdi.sdmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Date:2023/03/11/ 15:12
 * Author:leng
 * Description:
 */
@Component
public class StockQueryClientFallback implements StockQueryClient {

    @Override
    public List<ShoppingCartVO> query(String cids) {
        System.out.println("stock-query------服务降级");
        return null;
    }
}
