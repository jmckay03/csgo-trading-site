/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.service;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.csgo.model.SteamRGInventoryAndDescriptions;
import org.csgo.model.SteamRgDescriptionOnly;
import org.csgo.model.SteamRgInventoryOnly;
import org.csgo.repository.SteamInventoryItemRepository;
import org.csgo.repository.SteamInventoryUserItemsRepository;
import org.csgo.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.csgo.repository.SteamInventoryItemRepository;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SteamService {
    @Autowired
    private SteamInventoryItemRepository steamInventoryItemRepository;

    @Autowired
    private SteamInventoryUserItemsRepository steamInventoryUserItemsRepository;

    Gson gson = new Gson();

    // https://steamcommunity.com/profiles/76561198034418818/inventory/json/730/2
    // https://steamcommunity-a.akamaihd.net/economy/image/*image here*

    private String csgoBackpackUrl = "http://csgobackpack.net/api/GetItemsList/v2/?prettyprint=yes";
    private String csgoMarketUrl = "https://steamcommunity.com/market/listings/730/";

    //TODO Call every day with spring scheduler
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
                steamInventoryItemEntity.setIcon_url("https://steamcommunity-a.akamaihd.net/economy/image/"+steamInventoryItemFromApi.getIcon_url());
                if (steamInventoryItemFromApi.getPrice() != null) {
                    try {
                        if (!steamInventoryItemFromApi.getPrice().get("7_days").isJsonNull()){
                            SteamInventoryPrice steamInventoryPrice = gson.fromJson(steamInventoryItemFromApi.getPrice().get("7_days"), SteamInventoryPrice.class);
                            steamInventoryItemEntity.setAvgPrice(Float.parseFloat(steamInventoryPrice.getAverage()));
                        }
                    } catch (Exception e){
                        SteamInventoryPrice steamInventoryPrice = gson.fromJson(steamInventoryItemFromApi.getPrice().get("all_time"), SteamInventoryPrice.class);
                        steamInventoryItemEntity.setAvgPrice(Float.parseFloat(steamInventoryPrice.getAverage()));
                    }
                    //Save to DB from here
                    steamInventoryItemRepository.save(steamInventoryItemEntity);
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Exception: " + iterator.next().toString());
            }
        }
    }

    //Next we are going to be building up our inventory to check estimated steam inventory worth? /welcome
    //Random skin with similar value? /welcome
    // Getting all of your inventory /inventory

    public List<SteamInventoryUserItemsEntity> steamPriceCheckAllInventory(String steamId){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf("text/html; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        //Coming in as an object....
        ResponseEntity<SteamRGInventoryAndDescriptions> responseEntity = restTemplate.exchange("https://steamcommunity.com/profiles/" + steamId + "/inventory/json/730/2", HttpMethod.GET, entity, SteamRGInventoryAndDescriptions.class);

        Iterator iteratorInventory = responseEntity.getBody().getRgInventory().iterator();
        Iterator iteratorDescriptions = responseEntity.getBody().getRgDescriptions().iterator();

        //TODO add time, updates every 3 hours if user calls again...Saves to user db
        while (iteratorInventory.hasNext() && iteratorDescriptions.hasNext()) {
            SteamRgInventoryOnly steamRgInventoryOnly = gson.fromJson(iteratorInventory.next().toString(), SteamRgInventoryOnly.class);
            SteamRgDescriptionOnly steamRgDescriptionOnly = gson.fromJson(iteratorDescriptions.next().toString(), SteamRgDescriptionOnly.class);
            SteamInventoryItemEntity steamInventoryItemEntity = steamInventoryItemRepository.findByClassid(steamRgInventoryOnly.getClassid());
            //TODO Add Trade look up link
            if (steamRgDescriptionOnly.getMarketable().equals("1")){
                try {
                    System.out.println(steamInventoryItemEntity.toString());
                    steamInventoryUserItemsRepository.save(SteamInventoryUserItemsEntity.builder()
                            .steamId(steamId)
                            .classId(steamInventoryItemEntity.getClassid())
                            .name(steamInventoryItemEntity.getName())
                            .icon_url(steamInventoryItemEntity.getIcon_url())
                            .avgPrice(steamInventoryItemEntity.getAvgPrice())
                            .inspect(steamRgDescriptionOnly.getActions().get(0).getAsJsonObject().get("link").getAsString().replace("%owner_steamid%", steamId).replace("%assetid%", steamRgInventoryOnly.getId()))
                            .marketInspect(csgoMarketUrl + steamInventoryItemEntity.getName())
                            .build());
                } catch (Exception e) {
                    System.out.println("Error!");
                }
            }
        }
        return steamInventoryUserItemsRepository.findAllBySteamId(steamId);
    }
}
