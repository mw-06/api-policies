package com.api.policies.modules.core.infrastructure.adapters.out.persistence;

import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.domain.ports.out.LogPersistence;
import com.api.policies.modules.core.infrastructure.adapters.out.persistence.entities.LogEntity;
import com.api.policies.modules.core.infrastructure.adapters.out.persistence.mappers.LogMapper;
import com.api.policies.modules.core.infrastructure.adapters.out.persistence.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogPersistenceSql implements LogPersistence {
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private LogRepository logRepository;

    @Override
    public Log saveLog(Log log) {
        LogEntity logEntity = logMapper.modelToEntity(log);
        logEntity = logRepository.save(logEntity);
        log = logMapper.entityToModel(logEntity);
        return  log;
    }
}
