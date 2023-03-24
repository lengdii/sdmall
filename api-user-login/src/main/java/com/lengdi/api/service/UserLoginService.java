package com.lengdi.api.service;

import com.lengdi.sdmall.vo.ResultVO;

/**
 * Date:2023/03/10/ 18:11
 * Author:leng
 * Description:
 */
public interface UserLoginService {
    //用户登录
    public ResultVO checkLogin(String name, String pwd);

}
