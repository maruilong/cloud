package com.xinyuan.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: hwz
 * @Date: Created in 11:40 2018/12/18.
 */
@EnableEurekaClient
@SpringCloudApplication
@ComponentScan(basePackages = {"com.xinyuan"})
public class UploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }
}
