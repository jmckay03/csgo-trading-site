/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/24/2020
 */
package org.csgo.service;

import org.csgo.model.User;
import org.csgo.repository.SteamUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    SteamUserRepository steamUserRepository;


    @Override
    public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException {

        log.info("Loading user details ...");

        User user = new User();

        try {
            //You can find user by the token...
            log.info("Finding user by token " + token.getName());

            //steamUserRepository.save()
        } catch (RuntimeException e) {
            log.error("Runtime excetion");
        }
        return user;
    }
}
