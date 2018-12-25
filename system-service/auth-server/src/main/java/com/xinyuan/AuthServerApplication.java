package com.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 权限的校验端口
 *
 * @author liang
 */
@EnableEurekaClient
@SpringCloudApplication
@EnableAuthorizationServer
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    /**
     * 为测试环境添加相关的 Request Dumper information，便于调试
     *
     * @return
     */
//    @Profile("!cloud")
//    @Bean
//    RequestDumperFilter requestDumperFilter() {
//        return new RequestDumperFilter();
//    }

}
