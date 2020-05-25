/*
 * Copyright (C) 2020, Liberty Mutual Group
 *
 * Created on 5/25/2020
 */
package org.csgo.repository;

import org.csgo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface SteamUserRepository extends CrudRepository<User, Integer> {

}
