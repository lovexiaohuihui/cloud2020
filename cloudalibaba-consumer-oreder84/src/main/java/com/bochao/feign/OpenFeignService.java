package com.bochao.feign;

import com.bochao.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-sentinal-provide", fallback = OpfeignServiceFallback.class)
public interface OpenFeignService {

    @GetMapping("/payment/get/{id}")
    public Result getPayment(@PathVariable("id") String id);
}
