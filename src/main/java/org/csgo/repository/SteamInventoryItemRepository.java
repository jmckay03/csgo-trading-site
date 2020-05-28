package org.csgo.repository;

import org.csgo.repository.entity.SteamInventoryItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SteamInventoryItemRepository extends CrudRepository<SteamInventoryItemEntity, String> {

}
