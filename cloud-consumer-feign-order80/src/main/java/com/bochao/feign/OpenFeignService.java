package com.bochao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDE-PAYMENT")
public interface OpenFeignService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    Object getPaymentById(@PathVariable("id") String id);

    @GetMapping(value = "/payment/timeout")
    Object timeout();
}
