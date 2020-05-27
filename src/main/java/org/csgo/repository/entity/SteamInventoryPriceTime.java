/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/26/2020
 */
package org.csgo.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SteamInventoryPriceTime {
    @JsonProperty("7_days")
    private String sevenDays;

    public String getSevenDays() {
        return sevenDays;
    }

    public void setSevenDays(String sevenDays) {
        this.sevenDays = sevenDays;
    }
}
