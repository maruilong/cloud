package com.xinyuan.circle.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMysql",
        transactionManagerRef = "transactionManagerMysql",
        basePackages = {"com.xinyuan.circle.mapper.mysql"})
public class MysqlConfig {

    @Resource
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;

    @Value("${spring.jpa.properties.hibernate.mysql-dialect}")
    private String mysqlDialect;// 获取对应的数据库方言

    @Primary
    @Bean(name = "entityManagerMysql")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMysql(builder).getObject().createEntityManager();
    }



    @Resource
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties() {
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect",mysqlDialect);// 设置对应的数据库方言
        jpaProperties.setProperties(map);
        return jpaProperties.getProperties();
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactoryMysql")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMysql(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mysqlDataSource)
                .packages("com.xinyuan.circle.entity.mysql")
                .persistenceUnit("mysqlPersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerMysql")
    public PlatformTransactionManager transactionManagerMysql(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMysql(builder).getObject());
    }

}
