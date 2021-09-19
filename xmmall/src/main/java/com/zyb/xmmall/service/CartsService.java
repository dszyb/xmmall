package com.zyb.xmmall.service;

import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Component;

@Component
public interface CartsService {

    public ResultVO getCarts(int usersId);

    public ResultVO selectById(int goodsId,int usersId);

    public ResultVO insertCarts(int amount,int usersId,int goodsId);

    public ResultVO updateAmount(int amount,int id,int usersId);

    public ResultVO removeCartsById(int id);

    public ResultVO listCartsByIds(String ids);

}
