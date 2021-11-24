package com.bochao.controller;

import com.bochao.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/order")
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/ok")
    public String paymentOk() {
//        try {
//           return paymentFeignService.paymentOk();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e);
//        }
        return paymentFeignService.paymentOk();
    }

    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "paymentTimeoutHystrix", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentTimeout() throws Exception {
        try {
            // int num = 10 / 0;
            return paymentFeignService.paymentTimeout();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public String paymentTimeoutHystrix() {
        return "请稍后重试啊啊啊啊";
    }

    @GetMapping("/timeout2")
    @HystrixCommand
    public String paymentTimeout2() throws Exception {
        try {
            int num = 10 / 0;
            return paymentFeignService.paymentTimeout();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    /**
     * 全局降级处理
     * */
    public String globalFallback() {
        return "全局降级，请稍后重试";
    }
}
