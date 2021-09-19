package com.zyb.xmmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
public class Carts {
    private int id;
    private int amount;
    private int usersId;
    private int goodsId;
    private String cover;
    private String name;
    private float price;
    private Goods goods;

    public Carts(int id, int amount, int usersId, int goodsId, String cover, String name, float price) {
        this.id = id;
        this.amount = amount;
        this.usersId = usersId;
        this.goodsId = goodsId;
        this.cover = cover;
        this.name = name;
        this.price = price;
    }
}
