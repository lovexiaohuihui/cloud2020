package com.bochao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

    /**
     * 主键id
     * */
    private String id;

    /**
     * 订单号
     * */
    private String orderCode;
}
