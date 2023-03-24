package com.lengdi.sdmall.service;

import com.lengdi.sdmall.vo.ResultVO;

/**
 * Date:2023/02/03/ 14:15
 * Author:leng
 * Description:
 */
public interface CategoryService {

    public ResultVO listCategories();

    public ResultVO listFirstLevelCategories();

}
