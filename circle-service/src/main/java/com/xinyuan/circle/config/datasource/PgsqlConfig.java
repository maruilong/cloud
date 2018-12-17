package com.xinyuan.circle.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
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
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPgsql",
        transactionManagerRef = "transactionManagerPgsql",
        basePackages = {"com.xinyuan.circle.mapper.pgsql"})
public class PgsqlConfig {

    @Resource
    @Qualifier("mysqlDataSource")
    private DataSource pgsqlDataSource;

    @Primary
    @Bean(name = "entityManagerPgsql")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPgsql(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactoryPgsql")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPgsql(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(pgsqlDataSource)
                .packages("com.xinyuan.demo.model.pgsql")
                .persistenceUnit("pgsqlPersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerPgsql")
    public PlatformTransactionManager transactionManagerPgsql(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPgsql(builder).getObject());
    }
}
