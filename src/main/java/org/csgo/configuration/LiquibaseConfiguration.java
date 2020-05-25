/*
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on 2019-07-29
 */
package org.csgo.configuration;


import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.csgo.configuration.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquibaseConfiguration {

    @Autowired
    private LiquibaseProperties liquibaseProperties;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    public DataSource submissionRDSDeployDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(this.dataSourceProperties.getUrl());
        dataSource.setUsername(this.dataSourceProperties.getUsernameDeploy());
        dataSource.setPassword(this.dataSourceProperties.getSecretDeploy());
        dataSource.setDriverClassName(this.dataSourceProperties.getDriver());
        dataSource.setMaximumPoolSize(2);
        dataSource.setIdleTimeout(this.dataSourceProperties.getIdleTimeout());
        dataSource.setMaxLifetime(this.dataSourceProperties.getMaxLifetime());
        return dataSource;
    }

    public void testLiquibaseConnection() throws SQLException {
        log.debug(
                "RDS Liquibase Configuration >> testLiquibaseConnection() >> Testing Connection to Liquibase (in case PCF Restarts and we have Stale Dynamic Secrets)...");
        submissionRDSDeployDataSource().getConnection();
    }

    @Bean
    @PostConstruct
    public SpringLiquibase liquibase() {
        try {
            testLiquibaseConnection();
        } catch (Exception ex) {
            log.warn(
                    "RDS Liquibase Configuration >> liquibase() >> Could not connect to the liquibase data source, skipping liquibase deploy...",
                    ex.getMessage());
            return null;
        }
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(this.dataSourceProperties.getChangeLog());
        liquibase.setContexts(this.liquibaseProperties.getContexts());
        liquibase.setDataSource(submissionRDSDeployDataSource());
        liquibase.setDefaultSchema(this.liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(this.liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(this.liquibaseProperties.isEnabled());
        liquibase.setLabels(this.liquibaseProperties.getLabels());
        liquibase.setChangeLogParameters(this.liquibaseProperties.getParameters());
        return liquibase;
    }
}
