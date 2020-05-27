/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/26/2020
 */
package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SteamInventoryPriceTime {
    @JsonProperty("24_hours")
    private SteamInventoryPrice twentyfourhours;
    @JsonProperty("7_days")
    private SteamInventoryPrice sevenDays;
    @JsonProperty("30_days")
    private SteamInventoryPrice thirtyDays;
    @JsonProperty("all_time")
    private SteamInventoryPrice allTime;

    public SteamInventoryPrice getSevenDays() {
        return sevenDays;
    }

    public void setSevenDays(SteamInventoryPrice sevenDays) {
        this.sevenDays = sevenDays;
    }

    public SteamInventoryPrice getTwentyfourhours() {
        return twentyfourhours;
    }

    public void setTwentyfourhours(SteamInventoryPrice twentyfourhours) {
        this.twentyfourhours = twentyfourhours;
    }

    public SteamInventoryPrice getThirtyDays() {
        return thirtyDays;
    }

    public void setThirtyDays(SteamInventoryPrice thirtyDays) {
        this.thirtyDays = thirtyDays;
    }

    public SteamInventoryPrice getAllTime() {
        return allTime;
    }

    public void setAllTime(SteamInventoryPrice allTime) {
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
