package com.lengdi.controller;

import com.lengdi.sdmall.beans.Users;
import com.lengdi.sdmall.service.UserService;
import com.lengdi.sdmall.vo.ResStatus;
import com.lengdi.sdmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Date:2022/12/04/ 22:43
 * Author:leng
 * Description:
 */
@RestController
@RequestMapping("/user")
@Api(value = "提供用户的登录和注册接口",tags = "用户管理")
//允许跨域
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户登录账号",dataType = "string",paramType = "query",required = true),
            @ApiImplicitParam(name = "password",value = "用户登录密码",dataType = "string",paramType = "query",required = true)
    })
    @GetMapping("/login")
    public ResultVO login(
            @RequestParam(value = "username" ) String name,
            @RequestParam(value = "password") String pwd){
        ResultVO resultVO = userService.checkLogin(name, pwd);
        logger.info(resultVO.getMsg());
        return resultVO;
    }

    @ApiOperation("用户注册接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(dataType = "string",name = "username",value = "用户注册账号",required = true),
//            @ApiImplicitParam(dataType = "string",name = "password",value = "用户注册密码",required = true)
//    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户登录账号", dataType = "string", paramType = "query",  required = true),
            @ApiImplicitParam(name = "password", value = "用户登录密码", dataType = "string", paramType = "query",  required = true)
    })
    @PostMapping("/regist")
    public ResultVO regist(@RequestBody Users user){
        ResultVO resultVO = userService.userResgit(user.getUsername(), user.getUsername());
        return resultVO;
    }

    @ApiOperation("校验token是否过期接口")
    @GetMapping("/check")
    public ResultVO userTokencheck(@RequestHeader("token") String token){
        return new ResultVO(ResStatus.OK,"success",null);
    }


}
