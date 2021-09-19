package com.zyb.xmmall.controller;

import com.zyb.xmmall.entity.Carts;
import com.zyb.xmmall.service.CartsService;
import com.zyb.xmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api(tags = "购物车管理模块")
@Controller
@RequestMapping("api/v1")
public class CartsController {

    @Resource
    private CartsService cartsService;

    @ApiOperation("根据用户ID查询购物车")
    @GetMapping("/carts/getCarts")
    @ResponseBody
    public ResultVO getCarts(int usersId){
        ResultVO resultVO=cartsService.getCarts(usersId);
        return resultVO;
    }

    @ApiOperation("根据ID集合查询对应的信息")
    @GetMapping("/carts/listCartsByIds")
    @ResponseBody
    public ResultVO listCartsByIds(String ids){
        ResultVO resultVO = cartsService.listCartsByIds(ids);
        return resultVO;
    }

    @ApiOperation("添加购物车")
    @PostMapping("/carts/insertCarts")
    @ResponseBody
    public ResultVO insertCarts(@RequestBody Carts carts){
        int amount =carts.getAmount();
        int usersId=carts.getUsersId();
        int goodsId=carts.getGoodsId();
        ResultVO resultVO = cartsService.insertCarts(amount, usersId, goodsId);
        return resultVO;
    }

    @ApiOperation("更新购物车数量")
    @GetMapping("/carts/updateAmount/{amount}/{id}/{usersId}")
    @ResponseBody
    public ResultVO updateAmount(@PathVariable("amount")int amount, @PathVariable("id")int id, @PathVariable("usersId")int usersId){
        ResultVO resultVO = cartsService.updateAmount(amount, id,usersId);
        return resultVO;
    }

    @ApiOperation("移除单个购物车列表信息")
    @GetMapping("/carts/removeCartsById/{id}")
    @ResponseBody
    public ResultVO removeCartsById(@PathVariable("id")int id){
        ResultVO resultVO = cartsService.removeCartsById(id);
        return resultVO;
    }

}
