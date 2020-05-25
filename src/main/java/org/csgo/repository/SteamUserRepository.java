package org.csgo.repository;

import org.csgo.repository.entity.SteamUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jeffrey on 5/25/2020.
 */
@Repository
public interface SteamUserRepository extends CrudRepository<SteamUser, String>{
}