package org.csgo.controller;



import org.csgo.model.User;
import org.csgo.repository.SteamInventoryItemRepository;
import org.csgo.repository.SteamInventoryUserItemsRepository;
import org.csgo.repository.SteamUserRepository;
import org.csgo.repository.entity.SteamInventoryItemEntity;
import org.csgo.repository.entity.SteamInventoryUserItemsEntity;
import org.csgo.repository.entity.SteamUserEntity;
import org.csgo.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by Jeffrey on 5/24/2020.
 */

@Controller
public class WebPageController {

    @Autowired
    SteamUserRepository steamUserRepository;

    @Autowired
    SteamInventoryItemRepository steamInventoryItemRepository;

    @Autowired
    SteamInventoryUserItemsRepository steamInventoryUserItemsRepository;

    @Autowired
    SteamService steamService;


    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/welcome")
    public String profile(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nickName = ((User) principal).getUsername();
        String id = ((User) principal).getId().toString();

        if (principal != null) {
            List<SteamUserEntity> steamUserEntityList = steamUserRepository.findBySteamid(id);
            model.addAttribute("name", steamUserEntityList.get(0).getPersonaname());
            model.addAttribute("avatar", steamUserEntityList.get(0).getAvatarmedium());
        }
        return "welcome";
    }

    @GetMapping("/search")
    public String search(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nickName = ((User) principal).getUsername();
        String id = ((User) principal).getId().toString();

        if (principal != null) {
            Iterable<SteamInventoryItemEntity> steamInventoryItemEntities = steamInventoryItemRepository.findAll();
            model.addAttribute("inventory", steamInventoryItemEntities);
        }
        return "search";
    }

    @GetMapping("/inventory")
    @Transactional
    public String inventory(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((User) principal).getId().toString();
        List<SteamUserEntity> steamUserEntityList = steamUserRepository.findBySteamid(id);
        model.addAttribute("name", steamUserEntityList.get(0).getPersonaname());
        model.addAttribute("avatar", steamUserEntityList.get(0).getAvatarmedium());
        Date date = new Date();

        if (principal != null) {
            Timestamp latestTime = steamInventoryUserItemsRepository.findMinDateBySteamId(id);
            if (latestTime == null) {
                List<SteamInventoryUserItemsEntity> inventory = steamService.steamPriceCheckAllInventory(id);
                model.addAttribute("inventory", inventory);
                model.addAttribute("value", steamInventoryUserItemsRepository.sumOfAvgPrice(id).toString());
                System.out.println("Null");
            } else if (new Timestamp(date.getTime()).toLocalDateTime().isAfter(latestTime.toLocalDateTime().plusHours(3))) {
                steamInventoryUserItemsRepository.deleteBySteamId(id);
                List<SteamInventoryUserItemsEntity> inventory = steamService.steamPriceCheckAllInventory(id);
                model.addAttribute("inventory", inventory);
                model.addAttribute("value", steamInventoryUserItemsRepository.sumOfAvgPrice(id).toString());
                System.out.println(latestTime.toLocalDateTime().plusHours(3));
                System.out.println(new Timestamp(date.getTime()).toLocalDateTime());
                System.out.println("After 3 hours...");
            } else {
                List<SteamInventoryUserItemsEntity> inventory = steamInventoryUserItemsRepository.findAllBySteamId(id);
                model.addAttribute("inventory", inventory);
                model.addAttribute("value", steamInventoryUserItemsRepository.sumOfAvgPrice(id).toString());
                System.out.println("Within 3 hours... No update");
            }
        }
        return "inventory";
    }

    @GetMapping("/myTrades")
    @Transactional
    public String myTrades(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((User)principal).getId().toString();
        List<SteamUserEntity> steamUserEntityList = steamUserRepository.findBySteamid(id);
        model.addAttribute("name", steamUserEntityList.get(0).getPersonaname());
        model.addAttribute("avatar", steamUserEntityList.get(0).getAvatarmedium());
        Date date = new Date();

        if (principal != null) {
            Timestamp latestTime = steamInventoryUserItemsRepository.findMinDateBySteamId(id);
            if (latestTime == null) {
                List<SteamInventoryUserItemsEntity> inventory = steamService.steamPriceCheckAllInventory(id);
                model.addAttribute("inventory", inventory);
                Iterable<SteamInventoryItemEntity> defaultInventory = steamInventoryItemRepository.findAll();
                model.addAttribute("defaultInventory", defaultInventory);
            } else if (new Timestamp(date.getTime()).toLocalDateTime().isAfter(latestTime.toLocalDateTime().plusHours(3))){
                steamInventoryUserItemsRepository.deleteBySteamId(id);
                List<SteamInventoryUserItemsEntity> inventory = steamService.steamPriceCheckAllInventory(id);
                model.addAttribute("inventory", inventory);
                Iterable<SteamInventoryItemEntity> defaultInventory = steamInventoryItemRepository.findAll();
                model.addAttribute("defaultInventory", defaultInventory);
            } else {
                List<SteamInventoryUserItemsEntity> inventory = steamInventoryUserItemsRepository.findAllBySteamId(id);
                model.addAttribute("inventory", inventory);
                Iterable<SteamInventoryItemEntity> defaultInventory = steamInventoryItemRepository.findAll();
                model.addAttribute("defaultInventory", defaultInventory);
            }


        }
        return "createTrade";
    }

}
