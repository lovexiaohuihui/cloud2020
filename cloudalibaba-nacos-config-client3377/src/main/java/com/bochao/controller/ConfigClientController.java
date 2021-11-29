package com.bochao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope // 自动更新配置
public class ConfigClientController {

    @Value("${config.info}")
    private String conifInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info")
    public String getInfo() {
        return conifInfo + "\t" + "端口号：" + serverPort;
    }
}
