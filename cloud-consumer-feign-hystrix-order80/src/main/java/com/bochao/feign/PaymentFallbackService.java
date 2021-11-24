package com.bochao.feign;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public String paymentOk() {
        return "ok服务挂了";
    }

    @Override
    public String paymentTimeout() {
        return "timeout服务挂了";
    }
}
