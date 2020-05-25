/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.LocalDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User implements UserDetails {
    private Long id;

    private String fullName;

    private String steamNickname;

    private String avatarUrl;

    private LocalDateTime joinDateTime;

    private String aboutMe;

    private String telephone;

    private Set<UserOpenIds> userOpenIdsSet = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSteamNickname() {
        return steamNickname;
    }

    public void setSteamNickname(String steamNickname) {
        this.steamNickname = steamNickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public LocalDateTime getJoinDateTime() {
        return joinDateTime;
    }

    public void setJoinDateTime(LocalDateTime joinDateTime) {
        this.joinDateTime = joinDateTime;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<UserOpenIds> getUserOpenIdsSet() {
        return userOpenIdsSet;
    }

    public void setUserOpenIdsSet(Set<UserOpenIds> userOpenIdsSet) {
        this.userOpenIdsSet = userOpenIdsSet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        //return getUserOpenIdsSet().toArray(new UserOpenIds[0])[0].getOpenidUrl();
        return "Name";
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
