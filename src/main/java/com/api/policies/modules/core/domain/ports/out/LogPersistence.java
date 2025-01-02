package com.api.policies.modules.core.domain.ports.out;

import com.api.policies.modules.core.domain.models.Log;

public interface LogPersistence {
    Log saveLog(Log log);
}
