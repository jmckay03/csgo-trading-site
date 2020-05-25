/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.model;

import lombok.*;

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
    private String profileState;
    private String personaName;
    private String profileUrl;
    private String realName;


}
