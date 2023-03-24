package com.lengdi.sdmall.dao;

import com.lengdi.sdmall.entity.ProductComments;
import com.lengdi.sdmall.entity.ProductCommentsVO;
import com.lengdi.sdmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsMapper extends GeneralDAO<ProductComments> {

    /**
     * 根据商品ID分页查询评论信息
     * @param productId 商品ID
     * @param start 起始索引
     * @param limit 查询条数
     * @return
     */
    public List<ProductCommentsVO> selectCommontsByProductId(@Param("productId")String productId,
                                                             @Param("start") int start,
                                                             @Param("limit") int limit);

}