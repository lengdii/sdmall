package com.lengdi.api.controller;

import com.lengdi.api.service.UserLoginService;
import com.lengdi.sdmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Date:2023/03/10/ 18:04
 * Author:leng
 * Description:
 */
@RestController
@CrossOrigin
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/user/login")
    public ResultVO login(
            @RequestParam(value = "username" ) String name,
            @RequestParam(value = "password") String pwd){
        ResultVO resultVO = userLoginService.checkLogin(name, pwd);
        return resultVO;
    }
}
