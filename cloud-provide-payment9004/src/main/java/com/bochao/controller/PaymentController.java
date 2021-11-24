package com.bochao.controller;

import com.bochao.entity.Payment;
import com.bochao.entity.Result;
import com.bochao.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/addPayment")
    public Object addPayment(@RequestBody Payment payment) {
        try {
            paymentService.addPayment(payment);
            log.info("serverPort:-------------------------------" + serverPort);
            return new Result("200", "插入成功,serverPort:" + serverPort, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/getPaymentById")
    public Object getPaymentById(String id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            log.info("serverPort:-------------------------------" + serverPort);
            return new Result("200", "查询成功,serverPort:" + serverPort, payment);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("111", "查询失败", null);
        }
    }
}
