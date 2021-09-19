package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface ItemsDao {

    @Select("select * from items where orders_id=#{ordersId}")
    public List<Items> selectList(String ordersId);

    @Insert({"<script>",
            "insert into items(price,amount,orders_id,goods_id) values",
            "<foreach collection='itemsList' item='item' index='index' separator=','>",
            "(#{item.price},#{item.amount},#{item.ordersId},#{item.goodsId})",
            "</foreach>","</script>"})
    public int insertItems(@Param("itemsList")List<Items> itemsList);

}
