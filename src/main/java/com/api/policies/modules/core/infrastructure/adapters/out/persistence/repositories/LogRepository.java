package com.api.policies.modules.core.infrastructure.adapters.out.persistence.repositories;

import com.api.policies.modules.core.infrastructure.adapters.out.persistence.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Integer> {
}
