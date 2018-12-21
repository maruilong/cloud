package com.xinyuan.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: hwz
 * @Date: Created in 16:35 2018/12/17.
 */
@EnableEurekaClient
@SpringCloudApplication
@ComponentScan(basePackages = {"com.xinyuan"})
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
