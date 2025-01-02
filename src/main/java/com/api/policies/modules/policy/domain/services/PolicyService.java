package com.api.policies.modules.policy.domain.services;

import com.api.policies.modules.policy.domain.models.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> getPolicies();
    Policy getPolicyById(Integer idPolicy);
    Policy savePolicy(Policy policy);
    Policy deletePolicy(Integer idPolicy);
}
