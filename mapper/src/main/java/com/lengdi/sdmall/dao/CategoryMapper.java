package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.Category;
import com.lengdi.sdmall.entity.CategoryVO;
import com.lengdi.sdmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {

    //1.连接查询
    public List<CategoryVO> selectAllCategories();

    //2.子查询:根据parentId查询子分类
    public List<CategoryVO> selectAllCategories2(int parentId);

    //3.查询一级类别
    public List<CategoryVO> selectFirstLevelCategories();

}