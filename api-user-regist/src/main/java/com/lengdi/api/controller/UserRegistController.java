package com.lengdi.api.controller;

import com.lengdi.api.service.UserRegistService;
import com.lengdi.sdmall.beans.Users;
import com.lengdi.sdmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Date:2023/03/10/ 22:03
 * Author:leng
 * Description:
 */
@RestController
@CrossOrigin
public class UserRegistController {

    @Autowired
    private UserRegistService userRegistService;

    @PostMapping("user/regist")
    public ResultVO regist(@RequestBody Users user){
        ResultVO vo = userRegistService.regist(user.getUsername(), user.getPassword());
        return vo;
    }
}
