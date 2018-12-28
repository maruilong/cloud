package com.xinyuan.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author liang
 */
@EnableOAuth2Client
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ImApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }
}
