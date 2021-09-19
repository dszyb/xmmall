package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.CartsDao;
import com.zyb.xmmall.entity.Carts;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartsServiceImpl implements CartsService{

    @Resource
    private CartsDao cartsDao;

    @Override
    public ResultVO getCarts(int usersId) {
        List<Carts> list = cartsDao.getCarts(usersId);
        if (list!=null){
            return new ResultVO(10000,"成功",list);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO selectById(int goodsId, int usersId) {
        Carts carts = cartsDao.selectById(goodsId,usersId);
        if (carts!=null){
            return new ResultVO(10000,"成功",carts);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO insertCarts(int amount, int usersId, int goodsId) {
        Carts carts = cartsDao.selectById(goodsId,usersId);
        if (carts!=null){
            updateAmount(amount,carts.getId(), goodsId);
            return new ResultVO(10000,"成功",carts);
        }else {
            cartsDao.insertCarts(amount, usersId, goodsId);
            return new ResultVO(10000,"成功",carts);
        }
    }

    @Override
    public ResultVO updateAmount(int amount, int id, int usersId) {
        int i = cartsDao.updateAmount(amount, id, usersId);
        if (i>0) {
            return new ResultVO(10000,"成功",null);
        } else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO removeCartsById(int id) {
        int i =cartsDao.removeCartsById(id);
        if (i>0) {
            return new ResultVO(10000,"成功",null);
        } else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO listCartsByIds(String ids) {
        String[] arr = ids.split(",");
        List<Integer> cartsIds = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cartsIds.add(Integer.parseInt(arr[i]));
        }
        List<Carts> list=cartsDao.selectCartsByIds(cartsIds);
        if (list!=null) {
            return new ResultVO(10000,"成功",list);
        } else {
            return new ResultVO(10001,"失败",null);
        }
    }
}
