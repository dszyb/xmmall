package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.UsersDao;
import com.zyb.xmmall.entity.Users;
import com.zyb.xmmall.utils.MD5Util;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersDao usersDao;

    @Override
    public ResultVO userResgit(String phone, String password) {
        //1.根据用户手机号码，这个用户是否已经被注册
        Users users = usersDao.selectByPhone(phone);
        //2.如果没有被注册，则进行保存操作
        if (users==null) {
            String md5Pwd= MD5Util.strToMd5(password);
            int i=usersDao.registerUsers(phone,md5Pwd);
            if (i>0) {
                return new ResultVO(10000,"注册成功！",users);
            }else{
                return new ResultVO(10002,"注册失败！",null);
            }
        }else{
            return new ResultVO(10001,"用户已被注册",null);
        }
    }

    @Override
    public ResultVO checkLogin(String phone, String password) {
        Users users = usersDao.selectByPhone(phone);
        if (users==null) {
            return new ResultVO(10001,"登录失败",null);
        }else{
            String md5Pwd=MD5Util.strToMd5(password);
            if (md5Pwd.equals(users.getPassword())) {
                return new ResultVO(10000,"登录成功！",users);
            }else{
                return new ResultVO(10001,"登录失败,密码错误",null);
            }
        }
    }
}
