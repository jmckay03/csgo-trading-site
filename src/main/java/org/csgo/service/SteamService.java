/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.service;

import com.google.gson.Gson;
import org.csgo.repository.entity.SteamInventoryAll;
import org.csgo.repository.entity.SteamInventoryItemEntity;
import org.csgo.repository.entity.SteamInventoryItemFromApi;
import org.csgo.repository.entity.SteamInventoryPrice;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;

@Service
public class SteamService {
    Gson gson = new Gson();

    // https://steamcommunity.com/profiles/76561198034418818/inventory/json/730/2
    // https://steamcommunity-a.akamaihd.net/economy/image/*image here*

    private String csgoBackpackUrl = "http://csgobackpack.net/api/GetItemsList/v2/?prettyprint=yes";

    //Cache if called every hour...
    public void steamCacheInventory() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf("text/html; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        //Coming in as an object....
        ResponseEntity<SteamInventoryAll> responseEntity = restTemplate.exchange(csgoBackpackUrl, HttpMethod.GET, entity, SteamInventoryAll.class);

        Iterator iterator = responseEntity.getBody().getItemsList().iterator();

        while (iterator.hasNext()) {
            SteamInventoryItemEntity steamInventoryItemEntity = new SteamInventoryItemEntity();
            try{
                SteamInventoryItemFromApi steamInventoryItemFromApi = gson.fromJson(iterator.next().toString(), SteamInventoryItemFromApi.class);
                steamInventoryItemEntity.setName(steamInventoryItemFromApi.getName());
                steamInventoryItemEntity.setClassid(steamInventoryItemFromApi.getClassid());
                steamInventoryItemEntity.setIcon_url(steamInventoryItemFromApi.getIcon_url());
                if (steamInventoryItemFromApi.getPrice() != null) {
                    try {
                        if (!steamInventoryItemFromApi.getPrice().get("7_days").isJsonNull()){
                            SteamInventoryPrice steamInventoryPrice = gson.fromJson(steamInventoryItemFromApi.getPrice().get("7_days"), SteamInventoryPrice.class);
                            steamInventoryItemEntity.setAvgPrice(steamInventoryPrice.getAverage());
                        }
                    } catch (Exception e){
                        SteamInventoryPrice steamInventoryPrice = gson.fromJson(steamInventoryItemFromApi.getPrice().get("all_time"), SteamInventoryPrice.class);
                        steamInventoryItemEntity.setAvgPrice(steamInventoryPrice.getAverage());
                    }
                    System.out.println(steamInventoryItemEntity.toString());
                }
            } catch (Exception e) {
                System.out.println("Exception: " + iterator.next().toString());
            }

            //System.out.println(steamInventoryPriceTime.getSevenDays());
            //System.out.println(steamInventoryItemFromApi.getName() + " " + steamInventoryItemFromApi.getClassid());
            //System.out.println(steamInventoryItemFromApi.getPrice());
        }
    }

    public void steamPriceCheckAllInventory(String steamId){
        //fill in
    }
}
