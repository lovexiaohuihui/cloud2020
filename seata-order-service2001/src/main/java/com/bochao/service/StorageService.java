package com.bochao.service;

import com.bochao.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务feign
 * */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减少库存
     * */
    @PostMapping("/storage/reduce")
    Result reduce(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}
