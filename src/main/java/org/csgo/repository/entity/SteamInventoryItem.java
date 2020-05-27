package org.csgo.repository.entity;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;

public class SteamInventoryItem implements Serializable{
    private String name;
    private String classid;
    private String icon_url;
    private JsonNode price;

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

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public JsonNode getPrice() {
        return price;
    }

    public void setPrice(JsonNode price) {
        this.price = price;
    }
}
