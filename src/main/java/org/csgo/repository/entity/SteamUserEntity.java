/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.repository.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class SteamUserEntity implements Serializable {
    @Id
    private String steamid;
    private String communityvisibilitystate;
    private Integer profilestate;
    private String personaname;
    private String profileurl;
    private String realname;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private String avatarhash;
    private String lastlogoff;
    private Integer personastate;
    private String primaryclanid;
    private Long timecreated;
    private String loccountrycode;
    private String locstatecode;
    private String loccityid;

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public String getCommunityvisibilitystate() {
        return communityvisibilitystate;
    }

    public void setCommunityvisibilitystate(String communityvisibilitystate) {
        this.communityvisibilitystate = communityvisibilitystate;
    }

    public Integer getProfilestate() {
        return profilestate;
    }

    public void setProfilestate(Integer profilestate) {
        this.profilestate = profilestate;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public String getAvatarhash() {
        return avatarhash;
    }

    public void setAvatarhash(String avatarhash) {
        this.avatarhash = avatarhash;
    }

    public String getLastlogoff() {
        return lastlogoff;
    }

    public void setLastlogoff(String lastlogoff) {
        this.lastlogoff = lastlogoff;
    }

    public Integer getPersonastate() {
        return personastate;
    }

    public void setPersonastate(Integer personastate) {
        this.personastate = personastate;
    }

    public String getPrimaryclanid() {
        return primaryclanid;
    }

    public void setPrimaryclanid(String primaryclanid) {
        this.primaryclanid = primaryclanid;
    }

    public Long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Long timecreated) {
        this.timecreated = timecreated;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }

    public String getLocstatecode() {
        return locstatecode;
    }

    public void setLocstatecode(String locstatecode) {
        this.locstatecode = locstatecode;
    }

    public String getLoccityid() {
        return loccityid;
    }

    public void setLoccityid(String loccityid) {
        this.loccityid = loccityid;
    }
}
