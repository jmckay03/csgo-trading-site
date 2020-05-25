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


}
