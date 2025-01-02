package com.api.policies.modules.inventory.domain.ports.out;

import com.api.policies.modules.inventory.domain.models.Inventory;

import java.util.List;

public interface InventoryPersistence {
    List<Inventory> getInventories();
    Inventory getInventoryBySKU(String SKU);
    Inventory getInventoryById(Integer idInventory);
    Inventory saveInventory(Inventory inventory);
}
