package com.lengdi.user.dao;

import com.lengdi.sdmall.entity.Users;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Date:2023/03/10/ 21:27
 * Author:leng
 * Description:
 */
@Repository
public interface UserMapper extends Mapper<Users>, MySqlMapper<Users> {
}
