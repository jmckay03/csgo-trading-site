package org.csgo.controller;



import org.csgo.model.User;
import org.csgo.repository.SteamUserRepository;
import org.csgo.repository.entity.SteamUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String profile(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nickName = ((User)principal).getUsername();
        String id = ((User)principal).getId().toString();

        if (principal != null) {
            List<SteamUserEntity> steamUserEntityList = steamUserRepository.findBySteamid(id);
            model.addAttribute("name", steamUserEntityList.get(0).getPersonaname());
            model.addAttribute("avatar", steamUserEntityList.get(0).getAvatarmedium());
        }
        return "welcome";
    }

}
