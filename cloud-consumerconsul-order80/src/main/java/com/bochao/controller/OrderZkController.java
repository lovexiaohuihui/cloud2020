package com.bochao.controller;

import com.bochao.entity.Payment;
import com.bochao.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/consumerConsul/payment")
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    // private static final String PAYMENT_URL = "http://localhost:9001";
    private static final String PAYMENT_URL = "http://cloud-provide-payment";

    @PostMapping(value = "/addPayment")
    public Object addPayment(@RequestBody Payment payment) {
        try {
            return  restTemplate.postForObject(PAYMENT_URL + "/payment/addPayment", payment, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/getPaymentById")
    public Object getPaymentById(String id) {
        try {
            log.info("开始查询订单+++++++");
            return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById?id=" + id, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "查询失败", null);
        }
    }

    @GetMapping(value = "/getDiscovery")
    public Object get() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service ***************" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDE-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }
}
