/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/24/2020
 */
package org.csgo.configuration;

import org.csgo.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class SecurityWebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        AuthenticationSuccessHandler authenticationSuccessHandler = new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.sendRedirect("/welcome");
            }
        };

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/chat/**", "/dialogs/**", "/group/**", "/groups/**").permitAll()
                .antMatchers("/js/**", "/img/**", "/fonts/**","/css/**", "/bower_components/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/resources/**", "/webjars/**", "/built/**", "/static/**").permitAll()
                .and()
                .openidLogin()
                .loginPage("/").permitAll()
                .authenticationUserDetailsService(authenticationUserDetailsService())
                .successHandler(authenticationSuccessHandler)
                .failureUrl("/?fail")
                .and()
                .csrf().disable();
    }

    @Bean
    public AuthenticationUserDetailsService<OpenIDAuthenticationToken> authenticationUserDetailsService() {
        return new CustomUserDetailsService();
    }

}
