package com.xinyuan.circle;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liang
 */
@EnableSwagger2
@SpringCloudApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.xinyuan"})
public class CircleApplication {

    public static void main(String[] args) {
        new SpringApplication(CircleApplication.class).run(args);
    }
}
