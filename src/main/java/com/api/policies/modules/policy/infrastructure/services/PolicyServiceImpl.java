package com.api.policies.modules.policy.infrastructure.services;

import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.domain.ports.out.InventoryPersistence;
import com.api.policies.modules.policy.domain.models.Policy;
import com.api.policies.modules.policy.domain.ports.out.PolicyPersistence;
import com.api.policies.modules.policy.domain.services.PolicyService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyPersistence policyPersistence;
    @Autowired
    private InventoryPersistence inventoryPersistence;

    @Override
    public List<Policy> getPolicies() {
        return policyPersistence.getPolicies();
    }

    @Override
    public Policy getPolicyById(Integer idPolicy) {
        return policyPersistence.getPolicyById(idPolicy);
    }

    @SneakyThrows
    @Override
    public Policy savePolicy(Policy policy) {
        Inventory inventory = inventoryPersistence.getInventoryBySKU(policy.getInventory().getSku());
        if( inventory == null ) {
            throw new Exception("No se encontro inventario con ese SKU.");
        }
        policy.setInventory(inventory);

        if( policy.getQuantity() <= 0) {
            throw new Exception("Favor de ingresar una cantidad valida.");
        }
        if( policy.getEmployee() == null ) {
            throw new Exception("Favor de seleccionar un empleado.");
        }
        if( policy.getInventory() == null ) {
            throw new Exception("Favor de seleccionar un inventario.");
        }
        if( policy.getIdPolicy() == null ) {
            if( policy.getQuantity() > policy.getInventory().getQuantity() ) {
                throw new Exception("No hay inventario suficiente.");
            }
            policy.getInventory().setQuantity(policy.getInventory().getQuantity() - policy.getQuantity());
            policy.setDateTime(LocalDateTime.now(ZoneId.of("America/Mazatlan")));
        }
        Policy p = policyPersistence.savePolicy(policy);
        return policyPersistence.savePolicy(p);
    }

    @SneakyThrows
    @Override
    public Policy deletePolicy(Integer idPolicy) {
        Policy policy = policyPersistence.getPolicyById(idPolicy);
        if(policy.getStatus() == 99) {
            throw new Exception("El inventario con ID " + idPolicy+ " ya fue eliminado");
        }
        Inventory inventory = inventoryPersistence.getInventoryBySKU(policy.getInventory().getSku());
        inventory.setQuantity(inventory.getQuantity() + policy.getQuantity());
        policy.setInventory(inventory);
        policy.setStatus(99);

        return policyPersistence.savePolicy(policy);
    }
}
