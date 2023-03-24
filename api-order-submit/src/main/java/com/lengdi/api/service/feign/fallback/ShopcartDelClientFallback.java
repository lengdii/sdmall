package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.ShopcartDelClient;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/11/ 15:37
 * Author:leng
 * Description:
 */
@Component
public class ShopcartDelClientFallback implements ShopcartDelClient {

    public int delete(String cids) {
        System.out.println("shopcart-del ~~~~~~~ 服务降级");
        return 0;
    }

}
