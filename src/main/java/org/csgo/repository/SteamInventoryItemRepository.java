package org.csgo.repository;

import org.csgo.repository.entity.SteamInventoryItemEntity;
import org.csgo.repository.entity.SteamUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Jeffrey on 5/25/2020.
 */

@Repository
public interface SteamInventoryItemRepository extends CrudRepository<SteamInventoryItemEntity, String>{
    SteamInventoryItemEntity findByClassid(String classId);
    SteamInventoryItemEntity findByName(String name);

}
