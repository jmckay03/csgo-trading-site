package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class SteamInventoryAll implements Serializable {
    private String success;
    private String currency;
    private String timestamp;
    @JsonProperty("items_list")
    private Object itemsList;

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

    public Object getItemsList() {
        return itemsList;
    }

    public void setItemsList(Object itemsList) {
        this.itemsList = itemsList;
    }
}
