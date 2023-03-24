package com.lengdi.user.controller;

import com.lengdi.sdmall.entity.Users;
import com.lengdi.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/03/10/ 21:33
 * Author:leng
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserSaveController {

    @Autowired
    private UserSaveService userSaveService;

    @PostMapping("/save")
    public int save(@RequestBody Users user){
        return userSaveService.saveUser(user);
    }

}
