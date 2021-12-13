package com.bochao.service;

import com.bochao.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 金额账户feign
 * */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减金额
     * */
    @PostMapping("/account/deductMoney")
    Result deductMoney(@RequestParam("userId") String userId, @RequestParam("money") Double money);
}
