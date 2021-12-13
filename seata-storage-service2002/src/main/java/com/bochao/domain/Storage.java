package com.bochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
     * 主键id
     * */
    private String id;

    /**
     * 商品id
     * */
    private String productId;

    /**
     * 总库存
     * */
    private Integer total;

    /**
     * 已用库存
     * */
    private Integer used;

    /**
     * 剩余库存
     * */
    private Integer residue;
}
