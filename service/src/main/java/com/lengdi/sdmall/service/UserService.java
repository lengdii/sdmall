package com.lengdi.sdmall.service;

import com.lengdi.sdmall.vo.ResultVO;

/**
 * Date:2022/12/04/ 17:24
 * Author:leng
 * Description:
 */
public interface UserService {

    //用户注册
    public ResultVO userResgit(String name, String pwd);

    //用户登录
    public ResultVO checkLogin(String name, String pwd);

}
