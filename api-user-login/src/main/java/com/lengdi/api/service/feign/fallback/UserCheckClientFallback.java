package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.UserCheckClient;
import com.lengdi.sdmall.beans.Users;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/10/ 19:33
 * Author:leng
 * Description:
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {
    public Users check(String username) {
        //如果调用user-check服务失败,则直接返回null
        return null;
    }
}

