package com.lengdi.api.service.impl;

import com.lengdi.api.service.UserRegistService;
import com.lengdi.api.service.feign.UserCheckClient;
import com.lengdi.api.service.feign.UserSaveClient;
import com.lengdi.sdmall.beans.Users;
import com.lengdi.sdmall.utils.MD5Utils;
import com.lengdi.sdmall.vo.ResStatus;
import com.lengdi.sdmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Date:2023/03/10/ 21:42
 * Author:leng
 * Description:
 */
@Service
public class UserRegistServiceImpl implements UserRegistService {
    @Autowired
    private UserCheckClient userCheckClient;
    @Autowired
    private UserSaveClient userSaveClient;

    @Override
    public ResultVO regist(String name, String pwd) {
        synchronized (this) {
            //1.调用user-check服务 根据用户查询，这个用户是否已经被注册
            Users user = userCheckClient.check(name);

            //2.如果没有被注册则进行保存操作
            if (user == null) {
                String md5Pwd = MD5Utils.md5(pwd);
                user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());

                //3.调用user-save服务保存用户信息
                int i = userSaveClient.save(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else if(user.getUsername() == null) {
                return new ResultVO(ResStatus.NO, "网络出现故障，请重试！", null);
            } else{
                return new ResultVO(ResStatus.NO, "用户名已被注册，请更换用户名！", null);
            }
        }

    }
}
