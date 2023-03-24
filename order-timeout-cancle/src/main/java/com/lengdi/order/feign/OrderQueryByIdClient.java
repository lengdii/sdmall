package com.lengdi.order.feign;

import com.lengdi.sdmall.beans.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Date:2023/03/11/ 20:10
 * Author:leng
 * Description:
 */
@FeignClient("order-querybyid")
public interface OrderQueryByIdClient {

    @GetMapping("/order/query/{oid}")
    public Orders query(@PathVariable("oid") String oid);


}
