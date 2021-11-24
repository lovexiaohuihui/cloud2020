package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon负载均衡策略，默认轮询
 * @author 吴军杰
 * */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule(); // 随机策略
    }
}
