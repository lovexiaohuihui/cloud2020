package com.bochao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrederNacosController {

    @Value("${server-url.nacos-payment-server}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacos/get/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/get/" + id, String.class);
    }
}
