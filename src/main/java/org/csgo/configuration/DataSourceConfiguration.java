/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Aug 20, 2018
 */
package org.csgo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.csgo.configuration.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = {"org.csgo.repository.entity"}, //
        entityManagerFactoryRef = "entitiesManagerFactory", //
        transactionManagerRef = "entitiesTransactionManager")
@EnableConfigurationProperties(value = {DataSourceProperties.class})
public class DataSourceConfiguration {

    @Bean(name = "entitiesDataSource")
    public DataSource entitiesDataSource(DataSourceProperties dataSourceProperties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getSecret());
        dataSource.setDriverClassName(dataSourceProperties.getDriver());
        dataSource.setMaximumPoolSize(5);
        dataSource.setIdleTimeout(dataSourceProperties.getIdleTimeout());
        dataSource.setMaxLifetime(dataSourceProperties.getMaxLifetime());
        return dataSource;
    }

    @Bean("entitiesTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entitiesManagerFactory") EntityManagerFactory factory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(factory);
        JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setShowSql(true);
        jpaTransactionManager.setJpaPropertyMap(jpaProperties.getProperties());
        return jpaTransactionManager;
    }

    @Bean("entitiesManagerFactory")
    public LocalContainerEntityManagerFactoryBean managerFactory(
            @Qualifier("entitiesDataSource") DataSource entitiesDataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none"); //-> create to none
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.globally_quoted_identifiers", true);
        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), properties, null) //
                .dataSource(entitiesDataSource) //
                .packages("com.csgo.repository.entity").build();
    }

}
