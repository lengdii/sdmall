package com.lengdi.order.feign;

import com.lengdi.sdmall.beans.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Date:2023/03/11/ 20:11
 * Author:leng
 * Description:
 */
@FeignClient("order-status-update")
public interface OrderStatusUpdateClient {

    @PutMapping("/order/status/update")
    public int update(Orders order);

}
