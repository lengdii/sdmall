package com.lengdi.api.service.feign;

import com.lengdi.api.service.feign.fallback.UserSaveClientFallback;
import com.lengdi.sdmall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Date:2023/03/10/ 21:53
 * Author:leng
 * Description:
 */
@FeignClient(value = "user-save",fallback = UserSaveClientFallback.class)
public interface UserSaveClient {

    @PostMapping("user/save")
    public int save(Users user);

}
