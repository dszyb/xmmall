package com.zyb.xmmall.controller;

import com.zyb.xmmall.service.GoodsService;
import com.zyb.xmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api(tags = "商品管理模块")
@Controller
@RequestMapping("api/v1")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @ApiOperation("查询所有商品")
    @RequestMapping(value = "/goods/getAllGoods",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO getAllGoods(){
        ResultVO resultVO = goodsService.getAll();
        return resultVO;
    }

    @ApiOperation("根据商品ID查询商品信息")
    @RequestMapping(value = "/goods/getGoodsById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO getGoodsById(@PathVariable("id") int id){
        ResultVO resultVO = goodsService.getGoodsById(id);
        return resultVO;
    }

    @ApiOperation("根据类别ID查看商品")
    @RequestMapping(value = "/goods/getGoodsByCId/{categoryId}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO getGoodsByCId(@PathVariable("categoryId")int categoryId){
        ResultVO resultVO = goodsService.getGoodsByCId(categoryId);
        return resultVO;
    }

}
