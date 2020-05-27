/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/27/2020
 */
package org.csgo.repository.entity;

public class SteamInventoryPrice {
    private String average;
    private String median;
    private String sold;
    private String standard_deviation;
    private String lowest_price;
    private String highest_price;

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getStandard_deviation() {
        return standard_deviation;
    }

    public void setStandard_deviation(String standard_deviation) {
        this.standard_deviation = standard_deviation;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(String lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getHighest_price() {
        return highest_price;
    }

    public void setHighest_price(String highest_price) {
        this.highest_price = highest_price;
    }

    @Override
    public String toString() {
        return "SteamInventoryPrice{" +
                "average='" + average + '\'' +
                ", median='" + median + '\'' +
                ", sold='" + sold + '\'' +
                ", standard_deviation='" + standard_deviation + '\'' +
                ", lowest_price='" + lowest_price + '\'' +
                ", highest_price='" + highest_price + '\'' +
                '}';
    }
}
