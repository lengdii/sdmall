package com.lengdi.user.service.impl;

import com.lengdi.sdmall.entity.Users;
import com.lengdi.user.dao.UserMapper;
import com.lengdi.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date:2023/03/10/ 21:31
 * Author:leng
 * Description:
 */
@Service
public class UserServiceImpl implements UserSaveService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int saveUser(Users user) {
        int i = userMapper.insertUseGeneratedKeys(user);
        return i;
    }
}
