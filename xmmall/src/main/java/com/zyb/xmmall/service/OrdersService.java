package com.zyb.xmmall.service;

import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Component;

@Component
public interface OrdersService {

    public ResultVO getOrdersByUId(int usersId);

    public ResultVO insertOrders(int usersId,String ids,int receiverId,float total);

    public ResultVO selectByOId(String ordersId);

}
