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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class SteamUser {
    @Id
    private String steamId;
    private String communityVisibilityState;
    private Integer profileState;
    private String personaName;
    private String profileUrl;
    private String realName;
    private String avatar;
    private String avatarMedium;
    private String avatarFull;
    private String avatarHash;
    private String lastLogOff;
    private Integer personaState;
    private String primaryClanId;
    private Long timeCreated;
    private String loccountrycode;
    private String locstatecode;
    private String locCityId;


}
