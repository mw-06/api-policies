package com.api.policies.modules.policy.infrastructure.adapters.out.persistence;

import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import com.api.policies.modules.policy.domain.models.Policy;
import com.api.policies.modules.policy.domain.ports.out.PolicyPersistence;
import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.entities.PolicyEntity;
import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.mappers.PolicyMapper;
import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.repositories.PolicyRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyPersistenceSql implements PolicyPersistence {
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private PolicyMapper policyMapper;
    private Session session;
    @Override
    public List<Policy> getPolicies() {
        List<PolicyEntity> entities = policyRepository.findAll();
        return policyMapper.toModelList(entities);
    }

    @Override
    public Policy getPolicyById(Integer idPolicy) {
        PolicyEntity policyEntity = policyRepository.findById(idPolicy).get();
        return policyMapper.entityToModel(policyEntity);
    }

    @Override
    @Transactional
    public Policy savePolicy(Policy policy) {
        PolicyEntity policyEntity = policyMapper.modelToEntity(policy);
//        InventoryEntity inventory = session.load(InventoryEntity.class, policyEntity.getInventory().getIdInventory());
        policyEntity = policyRepository.save(policyEntity);
        policy = policyMapper.entityToModel(policyEntity);
        return  policy;
    }
}
