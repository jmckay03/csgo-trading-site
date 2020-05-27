package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class SteamInventoryAll implements Serializable {
    private String success;
    private String currency;
    private String timestamp;
    @JsonProperty("items_list")
    private JsonNode itemsList;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public JsonNode getItemsList() {
        return itemsList;
    }

    public void setItemsList(JsonNode itemsList) {
        this.itemsList = itemsList;
    }
}
