package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersDao {

    @Select("select * from users where phone=#{phone}")
    public Users selectByPhone(String phone);

    @Insert("insert into users(phone,password) values(#{phone},#{password})")
    public int registerUsers(@Param("phone") String phone,@Param("password") String password);

}
