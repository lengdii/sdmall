package com.lengdi.sdmall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Date:2022/12/08/ 21:06
 * Author:leng
 * Description:
 */
public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
