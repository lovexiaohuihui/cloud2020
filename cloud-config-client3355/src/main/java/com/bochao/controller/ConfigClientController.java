package com.bochao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigClientController {

    @Value("${config.info}")
    private String conifInfo;

    @GetMapping("/info")
    public String getInfo() {
        return conifInfo;
    }
}
