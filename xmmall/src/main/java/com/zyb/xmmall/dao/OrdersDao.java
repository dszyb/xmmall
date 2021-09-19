package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface OrdersDao {

    @Select("select o.orders_id,o.total,o.`status`,o.create_time,o.users_id,o.receiver_id,r.receiver_name,r.receiver_phone,r.receiver_address "+
            "from orders o join receiver r on o.receiver_id=r.receiver_id where o.users_id=#{usersId}")
    public List<Orders> getOrdersByUId(int usersId);

    @Insert("insert into orders(orders_id,total,status,create_time,users_id,receiver_id) values(#{ordersId},#{total},#{status},#{createTime},#{usersId},#{receiverId})")
    public int insertOrders(Orders orders);

    @Select("select o.*,r.receiver_name,r.receiver_phone,r.receiver_province,r.receiver_city,r.receiver_district,r.receiver_address "+
            "from orders o join receiver r on o.receiver_id=r.receiver_id where o.orders_id=#{ordersId}")
    public Orders selectByOId(String ordersId);


}
