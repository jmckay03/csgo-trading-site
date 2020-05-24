package org.csgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jeffrey on 5/24/2020.
 */

@Controller
public class WebPageController {

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }
}
