package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.*;
import com.zyb.xmmall.entity.*;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersDao ordersDao;

    @Resource
    private ItemsDao itemsDao;

    @Resource
    private CartsDao cartsDao;

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private ReceiverDao receiverDao;

    @Override
    public ResultVO getOrdersByUId(int usersId) {
        List<Orders> list = ordersDao.getOrdersByUId(usersId);
        for (Orders orders : list) {
            List<Items> itemsList = itemsDao.selectList(orders.getOrdersId());
            orders.setItems(itemsList);
            for (Items items : itemsList) {
                Goods goods = goodsDao.selectById(items.getGoodsId());
                items.setGoods(goods);
            }
            Receiver receiver = receiverDao.selectByRId(orders.getReceiverId());
            orders.setReceiver(receiver);
        }
        return new ResultVO(10000,"成功",list);
    }

    @Override
    public ResultVO insertOrders(int usersId, String ids, int receiverId, float total) {
        String[] arr = ids.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integerList.add(Integer.parseInt(arr[i]));
        }
        List<Carts> cartsList = cartsDao.selectCartsByIds(integerList);
        if (Objects.isNull(cartsList)||cartsList.isEmpty()){
            System.out.println("购物车没有选中要购买的商品");
        }
        
        boolean flag = true;
        int goodsId;
        for (Carts carts : cartsList) {
            goodsId = carts.getGoodsId();
            Goods goods = goodsDao.selectById(goodsId);
            carts.setGoods(goods);
            if (carts.getGoods().getQuantity()< carts.getAmount()){
                flag = false;
            }
        }

        if (flag){
            Orders orders = new Orders();
            String orderCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            orders.setOrdersId(orderCode);
            orders.setTotal(total);
            orders.setStatus(1);
            orders.setCreateTime(new Date());
            orders.setUsersId(usersId);
            orders.setReceiverId(receiverId);
            ordersDao.insertOrders(orders);

            List<Items> itemsList = new ArrayList<>();
            for (Carts carts : cartsList) {
                Items items = new Items();
                items.setPrice(carts.getGoods().getPrice());
                items.setAmount(carts.getAmount());
                items.setOrdersId(orders.getOrdersId());
                items.setGoodsId(carts.getGoodsId());
                itemsList.add(items);
                goodsDao.updateQuantity(carts.getAmount(),carts.getGoodsId());
            }
            itemsDao.insertItems(itemsList);
            for (int id : integerList) {
                cartsDao.removeCartsById(id);
            }
            return new ResultVO(10000,"库存充足",itemsList);
        }else {
            return new ResultVO(10001,"库存不足",null);
        }
    }

    @Override
    public ResultVO selectByOId(String ordersId) {
        Orders orders = ordersDao.selectByOId(ordersId);
        if (orders!=null){
            List<Items> itemsList = itemsDao.selectList(orders.getOrdersId());
            for (Items items : itemsList) {
                items.setGoods(goodsDao.selectById(items.getGoodsId()));
            }
            orders.setItems(itemsList);
            return new ResultVO(10000,"成功",orders);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

}
