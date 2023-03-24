package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.ProductImg;
import com.lengdi.sdmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    public List<ProductImg> selectProductImgByProductId(int productId);

}