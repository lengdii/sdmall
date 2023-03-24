package com.lengdi.order.service.feign.fallback;

import com.lengdi.order.service.feign.StockUpdateClient;
import com.lengdi.sdmall.beans.ProductSku;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockUpdateClientFallback implements StockUpdateClient {

    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock-update ~~~~~ 服务降级");
        return 0;
    }
}
