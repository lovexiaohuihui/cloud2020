package com.bochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 主键id
     * */
    private String id;

    /**
     * 用户id
     * */
    private String userId;

    /**
     * 商品id
     * */
    private String productId;

    /**
     * 购买数量
     * */
    private Integer count;

    /**
     * 金额
     * */
    private Double money;

    /**
     * 状态 0-创建中 1-已完成
     * */
    private Integer status;
}
