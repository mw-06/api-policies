package com.api.policies.modules.policy.domain.ports.in;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.policy.domain.models.Policy;

public interface PolicyRest {
    Response getPolicies();
    Response getPolicyById(Integer idPolicy);
    Response savePolicy(Policy policy);
    Response deletePolicy(Integer idPolicy);
}
