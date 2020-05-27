/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.csgo.repository.entity.SteamInventoryAll;
import org.csgo.repository.entity.SteamInventoryItem;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@Service
public class SteamService {
    Gson gson = new Gson();

    // https://steamcommunity.com/profiles/76561198034418818/inventory/json/730/2

    private String csgoBackpackUrl = "http://csgobackpack.net/api/GetItemsList/v2/?prettyprint=yes&no_prices=true";

    //Cache if called every hour...
    public void steamCacheInventory() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf("text/html; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        //Coming in as an object....
        ResponseEntity<SteamInventoryAll> responseEntity = restTemplate.exchange(csgoBackpackUrl, HttpMethod.GET, entity, SteamInventoryAll.class);

       // System.out.println(responseEntity.getBody().getItemsList());

        Iterator iterator = responseEntity.getBody().getItemsList().iterator();

        while (iterator.hasNext()) {
            SteamInventoryItem steamInventoryItem = gson.fromJson(iterator.next().toString(), SteamInventoryItem.class);
            System.out.println(steamInventoryItem.getName() + " " + steamInventoryItem.getClassid());
            //System.out.println(iterator.next().toString());
        }
    }

    public void steamPriceCheckAllInventory(String steamId){
        //fill in
    }
}
