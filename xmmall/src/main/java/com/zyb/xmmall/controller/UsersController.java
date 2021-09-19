package com.zyb.xmmall.controller;

import com.zyb.xmmall.entity.Users;
import com.zyb.xmmall.service.UsersService;
import com.zyb.xmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "用户管理模块")
@Controller
@RequestMapping("api/v1")
public class UsersController {

    @Resource
    private UsersService usersService;

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="string",name="phone",value="用户登录手机号码",required=true),
            @ApiImplicitParam(dataType="string",name="password",value="用户登录密码",required=true)
    })
    @GetMapping("/userLogin")
    @ResponseBody
    public ResultVO login(@RequestParam("phone")String phone, @RequestParam("password")String password){
        ResultVO resultVO = usersService.checkLogin(phone, password);
        return resultVO;
    }

    @ApiOperation("用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="string",name="phone",value="用户注册手机号码",required=true),
            @ApiImplicitParam(dataType="string",name="password",value="用户注册密码",required=true)
    })
    @RequestMapping(value="/userResgit",method= RequestMethod.POST)
    @ResponseBody
    public ResultVO regist(@RequestBody Users users){
        String phone = users.getPhone();
        String password = users.getPassword();
        ResultVO resultVO = usersService.userResgit(phone,password);
        return resultVO;
    }
}
