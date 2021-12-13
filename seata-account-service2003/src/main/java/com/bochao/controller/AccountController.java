package com.bochao.controller;

import com.bochao.domain.Result;
import com.bochao.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/deductMoney")
    public Result deductMoney(@RequestParam("userId") String userId, @RequestParam("money") Double money) {
        accountService.deductMoney(userId, money);
        return new Result("200", "扣钱成功", null);
    }
}
