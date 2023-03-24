package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.StockUpdateClient;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Date:2023/03/11/ 15:38
 * Author:leng
 * Description:
 */
@Component
public class StockUpdateClientFallback implements StockUpdateClient {
    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock-update ~~~~~~ 服务降级");
        return 0;
    }
}
