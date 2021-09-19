package com.zyb.xmmall.controller;

import com.zyb.xmmall.entity.Receiver;
import com.zyb.xmmall.service.ReceiverService;
import com.zyb.xmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api(tags = "收货地址管理模块")
@Controller
@RequestMapping("api/v1")
public class ReceiverController {

    @Resource
    private ReceiverService receiverService;

    @ApiOperation("查询全部收货地址信息")
    @RequestMapping(value = "/receiver/getAllReceiver",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO selectAll(){
        ResultVO resultVO = receiverService.selectAll();
        return resultVO;
    }

    @ApiOperation("根据用户ID查询收货地址信息")
    @RequestMapping(value = "/receiver/getReceiverById/{usersId}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO selectByUId(@PathVariable("usersId") int usersId){
        ResultVO resultVO = receiverService.selectByUId(usersId);
        return resultVO;
    }

    @ApiOperation("添加收货地址信息")
    @RequestMapping(value = "/receiver/insertReceiver",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO insertReceiver(@RequestBody Receiver receiver){
        int usersId = receiver.getUsersId();
        String receiverName = receiver.getReceiverName();
        String receiverPhone = receiver.getReceiverPhone();
        String receiverProvince=receiver.getReceiverProvince();
        String receiverCity=receiver.getReceiverCity();
        String receiverDistrict=receiver.getReceiverDistrict();
        String receiverAddress=receiver.getReceiverAddress();
        ResultVO resultVO = receiverService.insertReceiver(usersId,receiverName,receiverPhone,receiverProvince,receiverCity,receiverDistrict,receiverAddress);
        return resultVO;
    }

    @ApiOperation("修改收货地址信息")
    @RequestMapping(value = "/receiver/updateReceiver",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO updateReceiver(@RequestBody Receiver receiver){
        int receiverId = receiver.getReceiverId();
        String receiverName = receiver.getReceiverName();
        String receiverPhone = receiver.getReceiverPhone();
        String receiverProvince=receiver.getReceiverProvince();
        String receiverCity=receiver.getReceiverCity();
        String receiverDistrict=receiver.getReceiverDistrict();
        String receiverAddress=receiver.getReceiverAddress();
        ResultVO resultVO = receiverService.updateReceiver(receiverName,receiverPhone,receiverProvince,receiverCity,receiverDistrict,receiverAddress,receiverId);
        return resultVO;
    }

}
