package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.UserCheckClient;
import com.lengdi.sdmall.beans.Users;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/10/ 21:48
 * Author:leng
 * Description:
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {
    @Override
    public Users check(String username) {
        System.out.println("user-check ~~~~~~~ 服务降级");
        return new Users();
    }
}
