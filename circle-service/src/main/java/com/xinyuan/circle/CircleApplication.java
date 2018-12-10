package com.xinyuan.circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liang
 */
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.xinyuan.circle", "com.xinyuan.c"})
public class CircleApplication {

    public static void main(String[] args) {
        new SpringApplication(CircleApplication.class).run(args);
    }
}
