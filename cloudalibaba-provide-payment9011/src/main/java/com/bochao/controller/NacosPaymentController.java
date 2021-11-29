package com.bochao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Slf4j
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/get/{id}")
    public String getPayment(@PathVariable String id) {
        return "nacos 订单服务,端口号：" + serverPort + "  id:" + id;
    }
}
