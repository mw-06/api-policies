package com.api.policies.modules.inventory.infrastructure.adapters.in.rest;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.domain.services.LogService;
import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.domain.ports.in.InventoryRest;
import com.api.policies.modules.inventory.domain.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventories")
public class InventoryController implements InventoryRest {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private LogService logService;

    @Override
    @GetMapping("")
    public Response getInventories() {
        try {
            List<Inventory> inventories = inventoryService.getInventories();
            return Response.ok(inventories);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getInventories - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener los registros.", e.getMessage());
        }
    }

    @Override
    @GetMapping("/sku/{sku}")
    public Response getInventoryBySKU(@PathVariable String sku) {
        try {
            Inventory inventory = inventoryService.getInventoryBySKU(sku);
            return Response.ok(inventory);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getInventoryBySKU - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener los registros.", e.getMessage());
        }
    }

    @Override
    @GetMapping("/{idInventory}")
    public Response getInventoryById(@PathVariable Integer idInventory) {
        try {
            Inventory inventory = inventoryService.getInventoryById(idInventory);
            return Response.ok(inventory);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getInventoryById - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener e registro.", e.getMessage());
        }
    }

    @Override
    @PostMapping()
    public Response saveInventory(@RequestBody Inventory inventory) {
        try {
            Inventory inventorySaved = inventoryService.saveInventory(inventory);
            return Response.ok(inventorySaved);
        } catch( Exception e ) {
            Log log = new Log();
            log.setError("saveInventory - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al guardar el registro.", e.getMessage());
        }
    }
}
