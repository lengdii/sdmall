package com.lengdi.controller;

import com.lengdi.sdmall.service.UserAddrService;
import com.lengdi.sdmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

/**
 * Date:2023/02/16/ 16:01
 * Author:leng
 * Description:
 */
@RestController
@CrossOrigin
@Api(value = "提供收货人地址相关接口",tags = "收货地址管理")
@RequestMapping("/useraddr")
public class UserAddrController {

    @Autowired
    private UserAddrService userAddrService;

    @GetMapping("/list")
    @ApiImplicitParam(name = "userId",value = "用户Id",dataType = "int",paramType = "query",required = true)
    public ResultVO listAddr(Integer userId, @RequestHeader("token") String token){
        ResultVO resultVO = userAddrService.listAddrsByUid(userId);
        return resultVO;
    }

}
