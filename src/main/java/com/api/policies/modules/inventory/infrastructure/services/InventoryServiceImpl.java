package com.api.policies.modules.inventory.infrastructure.services;

import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.domain.ports.out.InventoryPersistence;
import com.api.policies.modules.inventory.domain.services.InventoryService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryPersistence inventoryPersistence;

    @Override
    public List<Inventory> getInventories() {
        return inventoryPersistence.getInventories();
    }

    @Override
    public Inventory getInventoryBySKU(String SKU) {
        return inventoryPersistence.getInventoryBySKU(SKU);
    }

    @SneakyThrows
    @Override
    public Inventory getInventoryById(Integer idInventory) {
        Inventory inventory = inventoryPersistence.getInventoryById(idInventory);
        if(inventory != null) {
            return inventory;
        } else {
            throw new Exception("No se encontro registro con ese ID");
        }
    }

    @SneakyThrows
    @Override
    public Inventory saveInventory(Inventory inventory) {
        if( inventory.getDescription().length() > 150 ) {
            throw new Exception ("La descripción no debe contener mas de 150 caracteres");
        }
        String sku = inventory.getSku();
        Inventory inventory1 = inventoryPersistence.getInventoryBySKU(sku);
        if( sku == null || sku.isEmpty() ) {
            throw new Exception ("El SKU no debe estar vacio.");
        }
        if(inventory1 != null && inventory.getIdInventory() != inventory1.getIdInventory()
                && inventory.getSku().equals(sku)
        ) {
            throw new Exception ("Ya existe un inventario con ese SKU");
        }
        if( inventory.getSku().length() > 100 ) {
            throw new Exception ("El SKU no debe contener mas de 100 caracteres");
        }
        if( inventory.getName().length() > 100 ) {
            throw new Exception ("El nombre no debe contener mas de 100 caracteres");
        }
        if( inventory.getName() == null || inventory.getName().isEmpty() ) {
            throw new Exception ("El nombre no debe estar vacio.");
        }
        return inventoryPersistence.saveInventory(inventory);
    }
}
