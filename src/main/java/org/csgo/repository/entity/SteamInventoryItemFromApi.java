package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;

import java.io.Serializable;

public class SteamInventoryItemFromApi implements Serializable{
    private String name;
    private String classid;
    private String icon_url;
    @JsonProperty("price")
    private JsonObject price;

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

    public JsonObject getPrice() {
        return price;
    }

    public void setPrice(JsonObject price) {
        this.price = price;
    }
}
