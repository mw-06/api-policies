package com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.repositories;

import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    InventoryEntity findBySku(String sku);
}
