/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/24/2020
 */
package org.csgo.service;

import org.csgo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    //@Autowired
    //SteamUserRepository steamUserRepository;

    String web_key = "88721AB6DB5DA8E1384A8DB9B493690C";

    @Override
    public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException {

        log.info("Loading user details ...");
        User user = new User();

        try {
            //You can find user by the token...
            log.info("Finding user by token " + token.getName());
            findSteamUserInfo(token.getName());

            //steamUserRepository.save()
        } catch (RuntimeException e) {
            log.error("Runtime excetion");
        }
        return user;
    }

    public void findSteamUserInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf("text/html; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + web_key
                + "&steamids=" + token;
        System.out.println(url);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody().toString());

    }
}
