/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/26/2020
 */
package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

public class SteamInventoryPriceTime {
    @JsonProperty("24_hours")
    private JsonObject twentyfourhours;
    @JsonProperty("7_days")
    private JsonObject sevenDays;
    @JsonProperty("30_days")
    private JsonObject thirtyDays;
    @JsonProperty("all_time")
    private JsonObject allTime;

    public JsonObject getTwentyfourhours() {
        return twentyfourhours;
    }

    public void setTwentyfourhours(JsonObject twentyfourhours) {
        this.twentyfourhours = twentyfourhours;
    }

    public JsonObject getSevenDays() {
        return sevenDays;
    }

    public void setSevenDays(JsonObject sevenDays) {
        this.sevenDays = sevenDays;
    }

    public JsonObject getThirtyDays() {
        return thirtyDays;
    }

    public void setThirtyDays(JsonObject thirtyDays) {
        this.thirtyDays = thirtyDays;
    }

    public JsonObject getAllTime() {
        return allTime;
    }

    public void setAllTime(JsonObject allTime) {
        this.allTime = allTime;
    }

    @Override
    public String toString() {
        return "SteamInventoryPriceTime{" +
                "twentyfourhours=" + twentyfourhours +
                ", sevenDays=" + sevenDays +
                ", thirtyDays=" + thirtyDays +
                ", allTime=" + allTime +
                '}';
    }
}
