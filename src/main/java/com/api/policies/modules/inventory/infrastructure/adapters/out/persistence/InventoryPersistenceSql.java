package com.api.policies.modules.inventory.infrastructure.adapters.out.persistence;

import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.domain.ports.out.InventoryPersistence;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.mappers.InventoryMapper;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryPersistenceSql implements InventoryPersistence {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> getInventories() {
        List<InventoryEntity> entities = inventoryRepository.findAll();
        return inventoryMapper.toModelList(entities);
    }

    @Override
    public Inventory getInventoryBySKU(String SKU) {
        InventoryEntity inventoryEntity = inventoryRepository.findBySku(SKU);
        if(inventoryEntity != null) {
            return inventoryMapper.entityToModel(inventoryEntity);
        } else {
            return null;
        }
    }

    @Override
    public Inventory getInventoryById(Integer idInventory) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(idInventory).get();
        return inventoryMapper.entityToModel(inventoryEntity);
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        InventoryEntity inventoryEntity = inventoryMapper.modelToEntity(inventory);
        inventoryEntity = inventoryRepository.save(inventoryEntity);
        inventory = inventoryMapper.entityToModel(inventoryEntity);
        return inventory;
    }
}
