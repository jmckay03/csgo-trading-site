package org.csgo.repository;

import org.csgo.repository.entity.SteamInventoryItemEntity;
import org.csgo.repository.entity.SteamInventoryUserItemsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jeffrey on 5/25/2020.
 */

@Repository
public interface SteamInventoryUserItemsRepository extends CrudRepository<SteamInventoryUserItemsEntity, String>{
    List<SteamInventoryUserItemsEntity> findAllBySteamId(String steamId);
    @Query(value = "SELECT SUM(t.avg_price) FROM STEAM_INVENTORY_USER_ITEMS_ENTITY t WHERE t.STEAM_ID = :steamId", nativeQuery = true)
    Float sumOfAvgPrice(String steamId);

}
