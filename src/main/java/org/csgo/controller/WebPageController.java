package org.csgo.controller;



import org.csgo.model.User;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


/**
 * Created by Jeffrey on 5/24/2020.
 */

@Controller
public class WebPageController {

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/welcome")
    public String profile(Principal principal, ModelMap model) {

        if (principal != null) {
            model.addAttribute("name", principal.getName());
            System.out.println(principal.getName());
        }
        return "welcome";
    }

}
