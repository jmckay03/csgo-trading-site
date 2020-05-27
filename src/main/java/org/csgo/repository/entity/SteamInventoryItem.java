package org.csgo.repository.entity;

import java.io.Serializable;

public class SteamInventoryItem implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
