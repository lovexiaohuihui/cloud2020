package com.bochao.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bochao.entity.Result;
import com.bochao.myhandle.CustomerBlockHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerExecption")
    public Result byResource() {
        return new Result("200", "资源名限流测试成功", null);
    }

    public Result handlerExecption(BlockException exception) {
        return new Result("444", exception.getClass().getCanonicalName(), null);
    }

    @GetMapping("/byUrl")
    public Result byUrl() {
        return new Result("200", "资源名限流测试成功", null);
    }

    @GetMapping("/byCustomer")
    @SentinelResource(value = "byCustomer", blockHandlerClass = CustomerBlockHandle.class, blockHandler = "customerBlockHandle2")
    public Result byCustomer() {
        return new Result("200", "资源名限流测试成功", null);
    }
}
