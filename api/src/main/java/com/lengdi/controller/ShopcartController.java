package com.lengdi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lengdi.sdmall.beans.Users;
import com.lengdi.sdmall.entity.ShoppingCart;
import com.lengdi.sdmall.service.ShoppingCartService;
import com.lengdi.sdmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 也就是说 注册的是通的，数据这里没有问题，那么 问题来了 controller这里 是通畅没问题的 对吧
 * 第二个 注册 你的前端 发送的  接口后台收到了，并且储存在数据库了 没毛病吧
 * 对 第三个  请求接口  稍等
 * Date:2022/12/12/ 22:51
 * Author:leng
 * Description:
 */
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "提供购物车业务相关接口",tags = "购物车管理")
public class ShopcartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/add")
    public ResultVO addShoppingCart(@RequestBody ShoppingCart cart, @RequestHeader("token")String token) throws JsonProcessingException {
        ResultVO resultVO = shoppingCartService.addShoppingCart(cart);
        String s = stringRedisTemplate.boundValueOps(token).get();
        Users users = objectMapper.readValue(s, Users.class);
        System.out.println(users);

//        System.out.println("Token:------>" + token);
//        System.out.println(resultVO);
//        System.out.println(cart);
        return resultVO;
    }

    @GetMapping("/list")
    @ApiImplicitParam(name = "userId",value = "用户Id",dataType = "int",paramType = "query",required = true)
    public ResultVO list(Integer userId,@RequestHeader("token")String token){
        ResultVO resultVO = shoppingCartService.listShoppingCartsByUserId(userId);
        return resultVO;
    }

    @PutMapping("/update/{cid}/{cnum}")
    public ResultVO updateNum(@PathVariable("cid") Integer cartId,
                              @PathVariable("cnum") Integer cartNum,
                              @RequestHeader("token") String token){
        ResultVO resultVO = shoppingCartService.updateCartNum(cartId, cartNum);
        return resultVO;
    }

    @GetMapping("/listbycids")
    @ApiImplicitParam(name = "cids",value = "用户Id",dataType = "String",paramType = "query",required = true)
    public ResultVO listByCids(String cids, @RequestHeader("token")String token){
        ResultVO resultVO = shoppingCartService.listShoppingCartsByCids(cids);
        return resultVO;
    }
}







