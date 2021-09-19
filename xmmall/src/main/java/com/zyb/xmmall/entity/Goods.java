package com.zyb.xmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String cover;
    private String name;
    private Float price;
    private String intro;
    private int quantity;
    private int categoryId;
    private List<GoodsSku> goodsSkus;
}
