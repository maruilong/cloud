package com.xinyuan.circle.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author shinian
 */
@Configuration
public class DataSourceConfig {

    //表示这个数据源是主的
    @Primary
    @Bean(name = "mrlDateSource")
    @ConfigurationProperties(prefix = "spring.datasource.mrl")
    public DataSource mrlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testDateSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }
}
