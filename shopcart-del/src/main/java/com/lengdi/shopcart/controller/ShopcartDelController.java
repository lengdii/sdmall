package com.lengdi.shopcart.controller;

import com.lengdi.shopcart.service.ShopcartDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/11/ 0:07
 * Author:leng
 * Description:
 */
@RestController
public class ShopcartDelController {

    @Autowired
    private ShopcartDelService shopcartDelService;

    @DeleteMapping("/shopcart/del")
    public int delete(String cids){
        return shopcartDelService.deleteShopcart(cids);
    }


}
