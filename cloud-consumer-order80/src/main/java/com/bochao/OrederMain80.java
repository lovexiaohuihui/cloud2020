package com.bochao;

import com.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PROVIDE-PAYMENT", configuration = MySelfRule.class)
public class OrederMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrederMain80.class, args);
    }
}
