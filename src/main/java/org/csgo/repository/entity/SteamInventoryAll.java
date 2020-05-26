package org.csgo.repository.entity;

import java.util.List;

public class SteamInventoryAll {
    private String success;
    private String currency;
    private String timestamp;
    private List<SteamInventoryItem> itemlist;

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

    public List<SteamInventoryItem> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<SteamInventoryItem> itemlist) {
        this.itemlist = itemlist;
    }
}
