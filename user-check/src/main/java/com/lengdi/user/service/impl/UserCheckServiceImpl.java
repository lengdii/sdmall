package com.lengdi.user.service.impl;

import com.lengdi.sdmall.entity.Users;
import com.lengdi.user.dao.UserMapper;
import com.lengdi.user.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Date:2023/03/10/ 19:09
 * Author:leng
 * Description:
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Users queryUser(String name) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",name);
        List<Users> users = userMapper.selectByExample(example);
        if(users.size()>0){
            return users.get(0);
        }else{
            return null;
        }
    }
}
