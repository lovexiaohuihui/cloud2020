package com.bochao.controller;

import com.bochao.domain.Result;
import com.bochao.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/getListOrder")
    public Result getListOrder() {
        return new Result("200", "查询成功", orderService.getListOrder());
    }

    @GetMapping("/createOrder")
    public Result createOrder() {
        orderService.createOrder();
        return new Result("200", "下单成功", null);
    }
}
