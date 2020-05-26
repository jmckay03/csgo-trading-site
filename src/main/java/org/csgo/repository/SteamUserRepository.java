package org.csgo.repository;

import org.csgo.repository.entity.SteamUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jeffrey on 5/25/2020.
 */

@Repository
public interface SteamUserRepository extends CrudRepository<SteamUserEntity, String>{
    List<SteamUserEntity> findBySteamid(String steamId);
}
