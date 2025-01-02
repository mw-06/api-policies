package com.api.policies.modules.policy.domain.ports.out;

import com.api.policies.modules.policy.domain.models.Policy;

import java.util.List;

public interface PolicyPersistence {
    List<Policy> getPolicies();
    Policy getPolicyById(Integer idPolicy);
    Policy savePolicy(Policy policy);
}
