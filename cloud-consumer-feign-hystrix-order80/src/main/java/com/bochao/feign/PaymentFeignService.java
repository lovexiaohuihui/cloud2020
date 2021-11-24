package com.bochao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDE-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/ok")
    String paymentOk();

    @GetMapping("/payment/timeout")
    String paymentTimeout();
}
