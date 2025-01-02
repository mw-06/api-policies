package com.api.policies.modules.core.domain.ports.in;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.core.domain.models.Log;

public interface LogRest {
    Response saveLog(Log log);
}
