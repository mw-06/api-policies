package com.api.policies.modules.inventory.domain.services;

import com.api.policies.modules.inventory.domain.models.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getInventories();
    Inventory getInventoryBySKU(String SKU);
    Inventory getInventoryById(Integer idInventory);
    Inventory saveInventory(Inventory inventory);

}
