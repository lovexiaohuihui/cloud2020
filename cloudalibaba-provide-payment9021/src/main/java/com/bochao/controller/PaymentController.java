package com.bochao.controller;

import com.bochao.entity.Payment;
import com.bochao.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<String, Payment> map = new HashMap<>();
    static {
        map.put("1", new Payment("1", "111111111111111"));
        map.put("2", new Payment("2", "222222222222222"));
        map.put("3", new Payment("3", "333333333333333"));
    }

    @GetMapping("/get/{id}")
    public Result getPayment(@PathVariable("id") String id) {
        Payment payment = map.get(id);
        return new Result("200", serverPort, payment);
    }
}
