package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.GoodsDao;
import com.zyb.xmmall.entity.Goods;
import com.zyb.xmmall.entity.GoodsSku;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Resource
    private GoodsDao goodsDao;

    @Override
    public ResultVO getAll() {
        List<Goods> list = goodsDao.getAllGoods();
        if (list!=null){
            return new ResultVO(10000,"成功",list);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO getGoodsById(int id) {
        List<GoodsSku> goodsSkuList = goodsDao.getAllGoodsSku(id);
        Goods goods = goodsDao.selectById(id);
        goods.setGoodsSkus(goodsSkuList);
        if (goods!=null){
            return new ResultVO(10000,"成功",goods);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO getGoodsByCId(int categoryId) {
        List<Goods> goodsList = goodsDao.selectByCId(categoryId);
        if (goodsList!=null){
            return new ResultVO(10000,"成功",goodsList);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

}
