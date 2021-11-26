package com.bochao.controller;

import com.bochao.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消息提供者controller
 * @author 吴军杰
 * */
@RestController
@RequestMapping("/stream")
public class IMessageProviderController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        iMessageProvider.send();
        return "成功";
    }
}
