/*
<<<<<<< HEAD
 * Copyright (C) 2019, Liberty Mutual Group
 *
 * Created on 2019-08-15
 */
package org.csgo.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "db.rds")
public class DataSourceProperties {

    private String url;
    private String username;
    private String secret;
    private String usernameDeploy;
    private String secretDeploy;
    private String changeLog;
    private String driver;
    private int maximumPoolSize;
    private int idleTimeout;
    private int maxLifetime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUsernameDeploy() {
        return usernameDeploy;
    }

    public void setUsernameDeploy(String usernameDeploy) {
        this.usernameDeploy = usernameDeploy;
    }

    public String getSecretDeploy() {
        return secretDeploy;
    }

    public void setSecretDeploy(String secretDeploy) {
        this.secretDeploy = secretDeploy;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }
}
