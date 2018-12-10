package com.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: hwz
 * @Date: Created in 17:31 2018/12/6.
 */
@SpringBootApplication
@EnableOAuth2Sso
@EnableEurekaClient
public class Client1Application {
    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class, args);
    }
}
