package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Carts;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CartsDao {

    @Select("select c.*,g.cover,g.name,g.price from carts c inner join goods g on c.goods_id=g.id where c.users_id=#{usersId}")
    public List<Carts> getCarts(int usersId);

    @Select("select c.*,g.cover,g.name,g.price from carts c inner join goods g on c.goods_id=g.id where c.goods_id=#{goodsId} and c.users_id=#{usersId}")
    public Carts selectById(@Param("goodsId")int goodsId, @Param("usersId")int usersId);

    @Insert("insert into carts(amount,users_id,goods_id) values(#{amount},#{usersId},#{goodsId})")
    public int insertCarts(@Param("amount")int amount,@Param("usersId")int usersId,@Param("goodsId")int goodsId);

    @Update("update carts set amount=#{amount} where id=#{id} and users_id=#{usersId}")
    public int updateAmount(@Param("amount")int amount,@Param("id")int id,@Param("usersId")int usersId);

    @Delete("delete from carts where id=#{id}")
    public int removeCartsById(@Param("id")int id);

    @Select("<script>" +
            "select * from carts where id in" +
            "<foreach collection='ids' index='index' item='cid' open='(' separator=',' close=')'>" +
            "#{cid}" +
            "</foreach>" +
            "</script>")
    public List<Carts> selectCartsByIds(@Param("ids")List<Integer> ids);

}
