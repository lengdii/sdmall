package com.lengdi;

import com.lengdi.sdmall.dao.*;
import com.lengdi.sdmall.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApiApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCommentsMapper productCommentsMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
        for(CategoryVO c1:categoryVOS){
            System.out.println(c1);
            for(CategoryVO c2:c1.getCategories()){
                System.out.println("\t"+c2);
                for(CategoryVO c3:c2.getCategories()){
                    System.out.println("\t\t"+c3);
                }
            }
        }
    }

    @Test
    public void testRecommend(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO p:productVOS){
            System.out.println(p);
        }
    }

    @Test
    public void testSelectFirstLevelCategory(){
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO c:categoryVOS) {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectCommonts(){
//        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommontsByProductId("3");
//        for (ProductCommentsVO p: productCommentsVOS) {
//            System.out.println(p);
//        }
    }

    @Test
    public void testShopCart(){
        String cids ="41,42";
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByCids(cidsList);
            for (ShoppingCartVO sc:list) {
                System.out.println(sc);
            }
    }

//    @Test
//    public void test(){
//        //1.查询超过30分钟订单状态依然待支付状态的订单
//        Example example = new Example(Orders.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("status","1");
//        Date time = new Date(System.currentTimeMillis()-30*60*1000);
//        criteria.andLessThan("createTime",time);
//
//        List<Orders> orders = ordersMapper.selectByExample(example);
//        for (int i = 0; i < orders.size(); i++) {
//            System.out.println(orders.get(i).getOrderId()+"\t" +orders.get(i).getCreateTime()+"\t"+orders.get(i).getStatus());
//        }
//    }

}
