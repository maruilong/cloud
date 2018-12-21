package com.xinyuan.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: hwz
 * @Date: Created in 10:03 2018/12/17.
 */
@EnableAdminServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }
}
