package com.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liang
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGetWayApplication.class, args);
    }
}
