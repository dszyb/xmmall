package com.zyb.xmmall.service;

import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Component;

@Component
public interface GoodsService {

    public ResultVO getAll();

    public ResultVO getGoodsById(int id);

    public ResultVO getGoodsByCId(int categoryId);

}
