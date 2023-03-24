package com.lengdi.sdmall.service;

import com.lengdi.sdmall.vo.ResultVO;

import java.util.List;

/**
 * Date:2023/02/11/ 21:38
 * Author:leng
 * Description:
 */
public interface ProductCommontsService {

    /**
     * 根据商品id实现评论的分页查询
     * @param productId 商品ID
     * @param pageNum 查询页码
     * @param limit 每页显示条数
     * @return
     */
    public ResultVO listCommontsByProductId(String productId,int pageNum,int limit);

    /**
     * 根据商品ID统计当前商品的评价信息
     * @param productId
     * @return
     */
    public ResultVO getCommentsCountByProductId(String productId);
}
