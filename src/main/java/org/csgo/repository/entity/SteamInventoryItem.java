package org.csgo.repository.entity;

import java.io.Serializable;

public class SteamInventoryItem implements Serializable{
    private String name;
    private String classid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
}
