package com.lengdi.api.service.feign.fallback;

import com.lengdi.api.service.feign.UserSaveClient;
import com.lengdi.sdmall.beans.Users;
import org.springframework.stereotype.Component;

/**
 * Date:2023/03/10/ 21:55
 * Author:leng
 * Description:
 */
@Component
public class UserSaveClientFallback implements UserSaveClient {
    @Override
    public int save(Users user) {
        return 0;
    }
}
