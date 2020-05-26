package org.csgo.controller;



import org.csgo.repository.SteamUserRepository;
import org.csgo.repository.entity.SteamUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


/**
 * Created by Jeffrey on 5/24/2020.
 */

@Controller
public class WebPageController {

    @Autowired
    SteamUserRepository steamUserRepository;


    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/welcome")
    public String profile(Principal principal, ModelMap model) {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (principal != null) {
            List<SteamUserEntity> steamUserEntityList = steamUserRepository.findBySteamid(authentication.getName());
            System.out.println(authentication.getName());
            model.addAttribute("name", steamUserEntityList.get(0).getPersonaname());
        }
        return "welcome";
    }

}
