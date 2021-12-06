package com.bochao.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class SentinalService {

    @SentinelResource(value = "service")
    public void test() {
        System.out.println("1111111111111111");
    }
}
