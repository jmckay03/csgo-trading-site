package org.csgo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Jeffrey on 5/24/2020.
 */
@RestController
public class BackEndService {

    @GetMapping("/test")
    public String getOidcUserPrincipal(Principal user) {
        System.out.println("Here");
        return user.getName();
    }
}
