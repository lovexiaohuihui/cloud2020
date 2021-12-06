package com.bochao.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bochao.service.SentinalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinal")
@Slf4j
public class SentinalServiceController {

    @Resource
    private SentinalService sentinalService;

    @GetMapping("/testA")
    public String testA() throws Exception {
        // TimeUnit.MILLISECONDS.sleep(2000);
        sentinalService.test();
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        sentinalService.test();
        return "testB";
    }

    @GetMapping("/testD")
    public String testD() throws Exception{
//        TimeUnit.MILLISECONDS.sleep(1000);
//        log.info("测试降级 RT");
        log.info("测试降级 异常比例");
        int age = 10 / 0;
        return "testD";
    }

    /**
     * 热点规则
     * */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "password", required = false) String password) {
        return "testHotKey";
    }

    /**
     * 热点规则
     * */
    public String deal_testHotKey(String name, String password, BlockException exception) {
        return "deal_testHotKey";
    }
}
