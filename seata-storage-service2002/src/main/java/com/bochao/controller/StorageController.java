package com.bochao.controller;

import com.bochao.domain.Result;
import com.bochao.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/reduce")
    public Result reduce(String productId, Integer count) {
        storageService.reduce(productId, count);
        return new Result("200", "扣减库存成功", null);
    }
}
