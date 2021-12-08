package com.bochao.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bochao.entity.Result;
import com.bochao.feign.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class ConsumerController {

    private static final String PAYMENT_URL = "http://cloud-sentinal-provide";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    // @SentinelResource(value = "fallback", fallback = "handleFallback")
    @SentinelResource(value = "fallback",
            fallback = "handleFallback",
            blockHandler = "handleException",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public Result getPayment(@PathVariable("id") String id) {
        Result result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);
        if ("4".equals(id)) {
            throw new IllegalArgumentException("非法参数异常");
        }
        if (result.getData() == null) {
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public Result handleFallback(@PathVariable("id") String id, Throwable e) {
        return new Result("444", e.getMessage(), null);
    }

    public Result handleException(@PathVariable("id") String id, BlockException exception) {
        return new Result("444", "服务被降级", null);
    }

    // openfeign
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/feign/get/{id}")
    public Result getPaymentByFeign(@PathVariable("id") String id) {
        return openFeignService.getPayment(id);
    }
}
