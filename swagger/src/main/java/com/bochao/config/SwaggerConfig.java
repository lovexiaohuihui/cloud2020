package com.bochao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  // 开启swagger2
public class SwaggerConfig {

    @Value("${spring.profiles.active}")
    private String active;

    @Bean
    public Docket docket1() {
        boolean flag = "dev".equals(active) ? true : false;
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("全部");
    }

    @Bean
    public Docket docket2() {
        boolean flag = "dev".equals(active) ? true : false;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag) // 页面是否可访问， 默认true可以访问
                .groupName("吴军杰的接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bochao.controller1")) // 扫描固定包下的
                .paths(PathSelectors.any()) // 过滤规则
                .build();
    }


    // 配置swagger的Docket的bean实例
    @Bean
    public Docket docket() {
        boolean flag = "dev".equals(active) ? true : false;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag) // 页面是否可访问， 默认true可以访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bochao.controller")) // 扫描固定包下的
                .paths(PathSelectors.any()) // 过滤规则
                .build();
    }

    // 配置swagger信息apiInfo
    private ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("吴军杰", "www.baidu.com", "1035626172@qq.com");

        return new ApiInfo(
                "博超api文档",
                "博超的api维护文档",
                "V1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
