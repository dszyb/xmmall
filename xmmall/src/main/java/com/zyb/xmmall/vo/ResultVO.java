package com.zyb.xmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    //响应码
    private int code;

    //提示消息
    private String msg;

    //响应数据
    private Object data;
}
