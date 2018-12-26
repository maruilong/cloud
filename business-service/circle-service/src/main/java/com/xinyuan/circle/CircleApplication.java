package com.xinyuan.circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liang
 */
@EnableOAuth2Sso
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
