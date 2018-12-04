package com.xinyuan.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liang
 */
@EnableHystrix
@EnableFeignClients
@EnableSwagger2
@SpringCloudApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.xinyuan"})
@EnableOAuth2Client
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
