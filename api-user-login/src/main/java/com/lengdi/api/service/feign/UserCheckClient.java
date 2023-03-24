package com.lengdi.api.service.feign;

import com.lengdi.api.service.feign.fallback.UserCheckClientFallback;
import com.lengdi.sdmall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date:2023/03/10/ 19:21
 * Author:leng
 * Description:
 */

@FeignClient(value = "user-check",fallback = UserCheckClientFallback.class)
public interface UserCheckClient {

    @GetMapping("user/check")
    public Users check(@RequestParam("username") String username);

}
