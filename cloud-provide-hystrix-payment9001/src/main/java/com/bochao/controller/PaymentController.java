package com.bochao.controller;

import com.bochao.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/ok")
    public String paymentOk() {
        log.info("ok---------------------------------");
        try {
            return paymentService.paymentOk();
        } catch (Exception e) {
            e.printStackTrace();
            return "失败了！@@@@@@";
        }
    }

    @GetMapping("/timeout")
    public String paymentTimeout() {
        log.info("timeout+++++++++++++++++++++++++++++++++++");
        try {
            return paymentService.paymentTimeout();
        } catch (Exception e) {
            e.printStackTrace();
            return "失败了！@@@@@@";
        }
    }

    /**
     * 服务熔断
     * */
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) throws Exception {
        return paymentService.paymentCircuitBreaker(id);
    }
}
