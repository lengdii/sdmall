package com.lengdi.user.controller;

import com.lengdi.sdmall.entity.Users;
import com.lengdi.user.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/10/ 19:04
 * Author:leng
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserCheckController {

    @Autowired
    private UserCheckService userCheckService;

    @GetMapping("/check")
    public Users check(String username){
        return userCheckService.queryUser(username);
    }

}
