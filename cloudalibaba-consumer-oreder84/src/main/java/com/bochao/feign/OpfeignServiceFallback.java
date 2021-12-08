package com.bochao.feign;

import com.bochao.entity.Result;
import org.springframework.stereotype.Component;

@Component
public class OpfeignServiceFallback implements OpenFeignService{

    @Override
    public Result getPayment(String id) {
        return new Result("8888", "feign被降级了", null);
    }
}
