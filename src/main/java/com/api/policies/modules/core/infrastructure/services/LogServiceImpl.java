package com.api.policies.modules.core.infrastructure.services;

import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.domain.ports.out.LogPersistence;
import com.api.policies.modules.core.domain.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogPersistence logPersistence;

    @Override
    public Log saveLog(Log log) {
        return logPersistence.saveLog(log);
    }
}
