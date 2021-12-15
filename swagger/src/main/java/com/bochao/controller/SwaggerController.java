package com.bochao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/getInfo")
    public String getInfo() {
        return "getInfo";
    }
}
