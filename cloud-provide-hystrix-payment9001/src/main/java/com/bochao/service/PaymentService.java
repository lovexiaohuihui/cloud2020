package com.bochao.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    public String paymentOk() {
        return Thread.currentThread().getName() + "       这是ok";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHystrix", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "13000")
    })
    public String paymentTimeout() throws Exception {
        int timeout = 6;
        TimeUnit.SECONDS.sleep(timeout);
        log.info("访问成功");
        return Thread.currentThread().getName() + "       这是超时";
    }

    public String paymentTimeoutHystrix() {
        return "请稍后重试";
    }

    /**
     * 服务熔断
     * */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期，10秒时间内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到则跳闸
            // 全部属性的意思 10秒内10次访问，失败率达到百分之六十，即六次，则跳闸
    })
    public String paymentCircuitBreaker(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号:" + uuid;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "调用失败了，id为负数";
    }
}
