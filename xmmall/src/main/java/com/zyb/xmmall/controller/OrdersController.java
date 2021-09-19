package com.zyb.xmmall.controller;

import com.zyb.xmmall.entity.Orders;
import com.zyb.xmmall.service.OrdersService;
import com.zyb.xmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api(tags = "订单详情管理模块")
@Controller
@RequestMapping("api/v1")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @ApiOperation("创建订单")
    @RequestMapping(value = "/orders/insertOrders",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO insertOrders(@RequestBody Orders orders){
        String ids = orders.getIds();
        int usersId = orders.getUsersId();
        int receiverId=orders.getReceiverId();
        float total =orders.getTotal();
        ResultVO resultVO = ordersService.insertOrders(usersId, ids, receiverId, total);
        return resultVO;
    }

    @ApiOperation("根据用户ID查询订单详情")
    @RequestMapping(value = "/orders/getOrders/{usersId}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO getOrdersByUId(@PathVariable("usersId") int usersId){
        ResultVO resultVO = ordersService.getOrdersByUId(usersId);
        return resultVO;
    }

    @ApiOperation("根据订单号查看详情")
    @RequestMapping(value = "/orders/selectByOId/{ordersId}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO selectByOId(@PathVariable("ordersId") String ordersId){
        ResultVO resultVO = ordersService.selectByOId(ordersId);
        return resultVO;
    }

}
