package com.lengdi.api.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date:2023/03/11/ 15:36
 * Author:leng
 * Description:
 */
@FeignClient("shopcart-del")
public interface ShopcartDelClient {

    @DeleteMapping("/shopcart/del")
    public int delete(@RequestParam("cids") String cids);

}