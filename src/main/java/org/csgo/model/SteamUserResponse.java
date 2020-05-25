package org.csgo.model;

import com.google.gson.JsonObject;

/**
 * Created by Jeffrey on 5/25/2020.
 */
public class SteamUserResponse {
    private JsonObject response;

    public JsonObject getResponse() {
        return response;
    }

    public void setResponse(JsonObject response) {
        this.response = response;
    }
}
