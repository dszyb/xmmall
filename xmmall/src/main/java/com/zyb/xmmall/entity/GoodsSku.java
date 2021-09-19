package com.zyb.xmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSku {
    private int skid;
    private String edition;
    private String color;
    private int goodsId;
}
