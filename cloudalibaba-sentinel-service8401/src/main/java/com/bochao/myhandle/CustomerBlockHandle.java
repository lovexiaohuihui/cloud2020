package com.bochao.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bochao.entity.Result;

/**
 * 自定义限流类
 * */
public class CustomerBlockHandle {

    public static Result customerBlockHandle1(BlockException exception) {
        return new Result("4444", "已经被限流了-----------------1", null);
    }

    public static Result customerBlockHandle2(BlockException exception) {
        return new Result("4444", "已经被限流了-----------------2", null);
    }
}
