package org.csgo.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;

/**
 * Created by Jeffrey on 5/29/2020.
 */
public class SteamRgDescriptionOnly {
    private String appId;
    private String classId;
    private String instanceId;
    private String icon_url;
    private String icon_url_large;
    private String icon_drag_url;
    private String name;
    private String market_hash_name;
    private String market_name;
    private String name_color;
    private String background_color;
    private String type;
    private String tradable;
    private String marketable;
    private String commodity;
    private String market_tradable_restriction;
    private JsonArray descriptions;
    private JsonArray actions;
    private JsonArray market_actions;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIcon_url_large() {
        return icon_url_large;
    }

    public void setIcon_url_large(String icon_url_large) {
        this.icon_url_large = icon_url_large;
    }

    public String getIcon_drag_url() {
        return icon_drag_url;
    }

    public void setIcon_drag_url(String icon_drag_url) {
        this.icon_drag_url = icon_drag_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket_hash_name() {
        return market_hash_name;
    }

    public void setMarket_hash_name(String market_hash_name) {
        this.market_hash_name = market_hash_name;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public String getName_color() {
        return name_color;
    }

    public void setName_color(String name_color) {
        this.name_color = name_color;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTradable() {
        return tradable;
    }

    public void setTradable(String tradable) {
        this.tradable = tradable;
    }

    public String getMarketable() {
        return marketable;
    }

    public void setMarketable(String marketable) {
        this.marketable = marketable;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getMarket_tradable_restriction() {
        return market_tradable_restriction;
    }

    public void setMarket_tradable_restriction(String market_tradable_restriction) {
        this.market_tradable_restriction = market_tradable_restriction;
    }

    public JsonArray getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(JsonArray descriptions) {
        this.descriptions = descriptions;
    }

    public JsonArray getActions() {
        return actions;
    }

    public void setActions(JsonArray actions) {
        this.actions = actions;
    }

    public JsonArray getMarket_actions() {
        return market_actions;
    }

    public void setMarket_actions(JsonArray market_actions) {
        this.market_actions = market_actions;
    }
}
