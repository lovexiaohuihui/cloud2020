package com.bochao.controller;

import com.bochao.entity.Result;
import com.bochao.feign.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/consumer/payment")
public class OpenFeignOrderController {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping(value = "/getPaymentById/{id}")
    public Object getPaymentById(@PathVariable("id") String id) {
        try {
            log.info("开始查询订单");
            return openFeignService.getPaymentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "查询失败", null);
        }
    }

    @GetMapping(value = "/timeout")
    public Object timeout() {
        try {
            return openFeignService.timeout();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "查询失败", null);
        }
    }
}
