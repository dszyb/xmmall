package com.zyb.xmmall.dao;

import com.zyb.xmmall.entity.Category;
import com.zyb.xmmall.entity.Goods;
import com.zyb.xmmall.entity.GoodsSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface GoodsDao {

    @Select("select * from category")
    public List<Category> getAllCategory();

    @Select("select * from goodssku where goods_id=#{goodsId}")
    public List<GoodsSku> getAllGoodsSku(int goodsId);

    @Select("select * from goods")
    public List<Goods> getAllGoods();

    @Select("select * from goods where category_id=#{categoryId}")
    public List<Goods> selectByCId(int categoryId);

    @Select("select * from goods where id=#{id}")
    public Goods selectById(int id);

    @Update("update goods set quantity=quantity-#{quantity} where id=#{id}")
    public int updateQuantity(@Param("quantity")int quantity, @Param("id")int id);

}
