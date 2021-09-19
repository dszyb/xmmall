package com.zyb.xmmall;

import com.zyb.xmmall.dao.GoodsDao;
import com.zyb.xmmall.dao.OrdersDao;
import com.zyb.xmmall.dao.ReceiverDao;
import com.zyb.xmmall.entity.*;
import com.zyb.xmmall.service.CategoryService;
import com.zyb.xmmall.service.GoodsService;
import com.zyb.xmmall.vo.ResultVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@SpringBootTest
class XmmallApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReceiverDao receiverDao;

    @Autowired
    OrdersDao ordersDao;

    @Test
    public void test1(){
        List<Goods> list = goodsDao.getAllGoods();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    @Test
    public void test2(){
        Goods goods = goodsDao.selectById(1);
        System.out.println(goods);
    }

    @Test
    public void test3(){
        List<GoodsSku> goodsSkuList = goodsDao.getAllGoodsSku(1);
        for (GoodsSku goodsSku : goodsSkuList) {
            System.out.println(goodsSku);
        }
    }

    @Test
    public void test4(){
        List<Category> categoryList = goodsDao.getAllCategory();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    @Test
    public void test5(){
       List<Receiver> list = receiverDao.selectAll();
        for (Receiver receiver : list) {
            System.out.println(receiver);
        }
    }

    @Test
    public void test6(){
        Receiver receiver = receiverDao.selectByRId(2);
        System.out.println(receiver);
    }

    @Test
    public void test7(){
        List<Receiver> receiverList = receiverDao.selectByUId(4);
        for (Receiver receiver : receiverList) {
            System.out.println(receiver);
        }
    }
    
    @Test
    public void test8(){
        Orders orders = new Orders();
        orders.setOrdersId("20210904231501");
        orders.setTotal(3599);
        orders.setUsersId(1);
        orders.setReceiverId(1);
        int result = ordersDao.insertOrders(orders);
        System.out.println(result);
    }

    @Test
    public void test9(){
        ResultVO resultVO = goodsService.getGoodsById(1);
        System.out.println(resultVO);
    }

    @Test
    public void test10(){
        ResultVO resultVO = categoryService.getAllCategory();
        System.out.println(resultVO);
    }

}
