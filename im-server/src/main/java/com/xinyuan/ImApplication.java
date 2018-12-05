package com.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class ImApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }
}
