package com.bochao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class HystrixDashboardMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain6001.class, args);
    }
}
