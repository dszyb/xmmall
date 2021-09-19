package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.GoodsDao;
import com.zyb.xmmall.entity.Category;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private GoodsDao goodsDao;

    @Override
    public ResultVO getAllCategory() {
        List<Category> categoryList = goodsDao.getAllCategory();
        if (categoryList!=null){
            return new ResultVO(10000,"成功",categoryList);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }
}
