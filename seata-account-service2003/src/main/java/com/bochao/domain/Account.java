package com.bochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    /**
     * 主键id
     * */
    private String id;

    /**
     * 用户id
     * */
    private String userId;

    /**
     * 总钱数
     * */
    private Double total;

    /**
     * 已用金额
     * */
    private Double used;

    /**
     * 剩余金额
     * */
    private Double residue;
}
