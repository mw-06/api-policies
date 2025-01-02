package com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.mappers;

import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InventoryMapper {
    public Inventory entityToModel(InventoryEntity inventoryEntity) {
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(inventoryEntity, inventory);
//        inventory.setIdInventory(inventoryEntity.getIdInventory());
//        inventory.setSku(inventoryEntity.getSku());
//        inventory.setName(inventoryEntity.getName());
//        inventory.setDescription(inventoryEntity.getDescription());
//        inventory.setQuantity(inventoryEntity.getQuantity());
        return inventory;
    }

    public InventoryEntity modelToEntity(Inventory inventory) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        BeanUtils.copyProperties(inventory, inventoryEntity);
//        inventoryEntity.setIdInventory(inventory.getIdInventory());
//        inventoryEntity.setSku(inventory.getSku());
//        inventoryEntity.setName(inventory.getName());
//        inventoryEntity.setDescription(inventory.getDescription());
//        inventoryEntity.setQuantity(inventory.getQuantity());
        return inventoryEntity;
    }

    public List<Inventory> toModelList(List<InventoryEntity> inventoryEntities) {
        List<Inventory> inventories = new ArrayList<>();
        for (InventoryEntity inventoryEntity : inventoryEntities){
            Inventory inventory =  entityToModel(inventoryEntity);
            inventories.add(inventory);
        }
        return inventories;
    }

    public Set<InventoryEntity> toEntityList(Set<Inventory> inventories ) {
        Set<InventoryEntity> inventoryEntities = new HashSet<>();
        for ( Inventory inventory : inventories) {
            InventoryEntity inventoryEntity = modelToEntity(inventory);
            inventoryEntities.add(inventoryEntity);
        }
        return inventoryEntities;
    }

}
