package com.xinyuan.relation;

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
@ComponentScan(basePackages = {"com.xinyuan.relation", "com.xinyuan.base"})
public class RelationApplication {

    public static void main(String[] args) {
        new SpringApplication(RelationApplication.class).run(args);
    }
}
