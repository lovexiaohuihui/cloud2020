package com.bochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 返回状态码
     * */
    private String code;

    /**
     * 返回信息
     * */
    private String message;

    /**
     * 返回数据
     * */
    private T data;
}
