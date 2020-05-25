package org.csgo.model;

import java.io.Serializable;


public class UserOpenIds implements Serializable {

    private String openidUrl;

    private User user;

    public UserOpenIds() {
    }

    public UserOpenIds(String openidUrl) {
        this.openidUrl = openidUrl;
    }


    public String getOpenidUrl() {
        return openidUrl;
    }

    public void setOpenidUrl(String openidUrl) {
        this.openidUrl = openidUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
