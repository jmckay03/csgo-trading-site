/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/27/2020
 */
package org.csgo.model;

import com.fasterxml.jackson.databind.JsonNode;

public class SteamRGInventoryAndDescriptions {
    private String success;
    private JsonNode rgInventory;
    private JsonNode rgDescriptions;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public JsonNode getRgInventory() {
        return rgInventory;
    }

    public void setRgInventory(JsonNode rgInventory) {
        this.rgInventory = rgInventory;
    }

    public JsonNode getRgDescriptions() {
        return rgDescriptions;
    }

    public void setRgDescriptions(JsonNode rgDescriptions) {
        this.rgDescriptions = rgDescriptions;
    }
}
