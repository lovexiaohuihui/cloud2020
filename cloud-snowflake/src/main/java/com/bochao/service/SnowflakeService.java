package com.bochao.service;

import com.bochao.util.SnowflakeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SnowflakeService {

    @Resource
    private SnowflakeUtil snowflakeUtil;

    public void getSnowflakeId() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(snowflakeUtil.getSnowflakeId());
            });
        }
        threadPool.shutdown();
    }
}
