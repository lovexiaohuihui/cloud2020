package com.bochao.controller;

import com.bochao.service.SnowflakeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/snowflake")
public class SnowflakeController {

    @Resource
    private SnowflakeService snowflakeService;

    @GetMapping("/getId")
    public String getSnowflakeId() {
        snowflakeService.getSnowflakeId();
        return "雪花算法";
    }
}
