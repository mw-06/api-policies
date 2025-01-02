package com.api.policies.modules.policy.infrastructure.adapters.out.persistence.mappers;

import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.mappers.EmployeeMapper;
import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.mappers.InventoryMapper;
import com.api.policies.modules.policy.domain.models.Policy;
import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.entities.PolicyEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PolicyMapper {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private InventoryMapper inventoryMapper;

    public Policy entityToModel(PolicyEntity policyEntity) {
        Policy policy = new Policy();
//        policy.setIdPolicy(policyEntity.getIdPolicy());
//        policy.setEmployee(employeeMapper.entityToModel(policyEntity.getEmployee()));
//        policy.setInventory(inventoryMapper.entityToModel(policyEntity.getInventory()));
//        policy.setQuantity(policyEntity.getQuantity());
//        policy.setDateTime(policyEntity.getDateTime());
//        policy.setStatus(policyEntity.getStatus());
        BeanUtils.copyProperties(policyEntity, policy);
        policy.setEmployee(employeeMapper.entityToModel(policyEntity.getEmployee()));
        policy.setInventory(inventoryMapper.entityToModel(policyEntity.getInventory()));
        return policy;
    }

    public PolicyEntity modelToEntity(Policy policy) {
        PolicyEntity policyEntity = new PolicyEntity();
        BeanUtils.copyProperties(policy, policyEntity);
        policyEntity.setEmployee(employeeMapper.modelToEntity(policy.getEmployee()));
        policyEntity.setInventory(inventoryMapper.modelToEntity(policy.getInventory()));
        return policyEntity;
    }

    public List<Policy> toModelList(List<PolicyEntity> policyEntities) {
        List<Policy> policies = new ArrayList<>();
        for (PolicyEntity policyEntity : policyEntities){
            Policy policy =  entityToModel(policyEntity);
            policies.add(policy);
        }
        return policies;
    }

    public Set<PolicyEntity> toEntityList(Set<Policy> policies ) {
        Set<PolicyEntity> policyEntities = new HashSet<>();
        for ( Policy policy : policies) {
            PolicyEntity policyEntity = modelToEntity(policy);
            policyEntities.add(policyEntity);
        }
        return policyEntities;
    }
}
