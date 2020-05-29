package org.csgo.controller;

import org.csgo.model.User;
import org.csgo.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Jeffrey on 5/24/2020.
 */
@RestController
public class BackEndService {

    @Autowired
    private SteamService steamService;

    @GetMapping("/load-data")
    public void getAllInventoryItems() throws Exception {
        steamService.steamCacheInventory();
    }

    @GetMapping("/user-data")
    public String getUserInventoryItems() throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((User)principal).getId().toString();
        return steamService.steamPriceCheckAllInventory(id);
    }
}
