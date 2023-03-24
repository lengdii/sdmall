package com.lengdi.sdmall.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Date:2023/02/11/ 22:53
 * Author:leng
 * Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper<T> {

    //总记录数
    private int count;

    //总页数
    private int pageCount;

    //分页数据
    private List<T> list;

}
