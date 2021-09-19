package com.zyb.xmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private int itemsId;
    private float price;
    private int amount;
    private String ordersId;
    private int goodsId;
    private Goods goods;
}