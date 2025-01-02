package com.api.policies.modules.inventory.domain.ports.in;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.inventory.domain.models.Inventory;

public interface InventoryRest {
    Response getInventories();
    Response getInventoryBySKU(String SKU);
    Response getInventoryById(Integer idInventory);
    Response saveInventory(Inventory inventory);
}
