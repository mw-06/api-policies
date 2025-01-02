package com.api.policies.modules.core.infrastructure.adapters.out.persistence.mappers;

import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.infrastructure.adapters.out.persistence.entities.LogEntity;
import org.springframework.stereotype.Service;
@Service
public class LogMapper {
        public Log entityToModel(LogEntity logEntity) {
            Log log = new Log();
            log.setIdLog(logEntity.getIdLog());
            log.setError(logEntity.getError());

            return log;
        }

        public LogEntity modelToEntity(Log log) {
            LogEntity logEntity = new LogEntity();
            logEntity.setIdLog(log.getIdLog());
            logEntity.setError(log.getError());

            return logEntity;
        }
}
