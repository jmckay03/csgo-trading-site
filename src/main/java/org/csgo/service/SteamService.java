/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.service;

import org.springframework.stereotype.Service;

@Service
public class SteamService {

    // https://steamcommunity.com/profiles/76561198034418818/inventory/json/730/2

    //Cache if called every hour...
    public void steamCacheInventory(String steamId){

    }

    public void steamPriceCheckAllInventory(String steamId){
        //fill in
    }
}
