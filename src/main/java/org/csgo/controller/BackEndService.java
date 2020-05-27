package org.csgo.controller;

import org.csgo.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/test")
    public void getOidcUserPrincipal() {
        steamService.steamCacheInventory();
    }
}
