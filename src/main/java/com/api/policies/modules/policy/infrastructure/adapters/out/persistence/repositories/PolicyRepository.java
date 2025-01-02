package com.api.policies.modules.policy.infrastructure.adapters.out.persistence.repositories;

import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.entities.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer> {
}
