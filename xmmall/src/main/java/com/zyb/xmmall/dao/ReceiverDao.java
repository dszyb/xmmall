package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Receiver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface ReceiverDao {

    @Select("select * from receiver")
    public List<Receiver> selectAll();

    @Select("select * from receiver where receiver_id=#{receiverId}")
    public Receiver selectByRId(int receiverId);

    @Select("select * from receiver where users_id=#{usersId}")
    public List<Receiver> selectByUId(int usersId);

    @Insert("insert into receiver(users_id,receiver_name,receiver_phone,receiver_province,receiver_city,receiver_district,receiver_address)\n" +
            "values(#{usersId},#{receiverName},#{receiverPhone},#{receiverProvince},#{receiverCity},#{receiverDistrict},#{receiverAddress})")
    public int insertReceiver(@Param("usersId") int usersId,@Param("receiverName") String receiverName,@Param("receiverPhone") String receiverPhone,@Param("receiverProvince") String receiverProvince,@Param("receiverCity") String receiverCity,@Param("receiverDistrict") String receiverDistrict,@Param("receiverAddress") String receiverAddress);

    @Update("update receiver set receiver_name=#{receiverName},receiver_phone=#{receiverPhone},receiver_province=#{receiverProvince},receiver_city=#{receiverCity},receiver_district=#{receiverDistrict},receiver_address=#{receiverAddress} where receiver_id=#{receiverId}")
    public int updateReceiver(@Param("receiverName")String receiverName,@Param("receiverPhone")String receiverPhone,@Param("receiverProvince")String receiverProvince,@Param("receiverCity")String receiverCity,@Param("receiverDistrict")String receiverDistrict,@Param("receiverAddress")String receiverAddress,@Param("receiverId") int receiverId);

}
