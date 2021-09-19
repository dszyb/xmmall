package com.zyb.xmmall.service;

import com.zyb.xmmall.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UsersService {

    public ResultVO userResgit(@Param("phone") String phone,@Param("password") String password);

    public ResultVO checkLogin(@Param("phone")String phone,@Param("password")String password);

}
