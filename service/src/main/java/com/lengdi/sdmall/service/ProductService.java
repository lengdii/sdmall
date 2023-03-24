package com.lengdi.sdmall.service;

import com.lengdi.sdmall.vo.ResultVO;

/**
 * Date:2023/02/09/ 22:01
 * Author:leng
 * Description:
 */
public interface ProductService {

    public ResultVO listRecommendProducts();

    public ResultVO getProductBasicInfo(String productId);

    public ResultVO getProductParamsById(String productId);

    public ResultVO getProductsByCategoryId(int categoryId,int pageNum,int limit);

    public ResultVO listBrands(int categoryId);

    public ResultVO searchProduct(String kw,int pageNum,int limit);

    public ResultVO listBrands(String kw);



}
