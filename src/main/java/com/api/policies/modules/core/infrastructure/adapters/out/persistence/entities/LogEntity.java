package com.api.policies.modules.core.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "core_logs")
@Getter
@Setter
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Integer idLog;

    @Lob
    @Column(name = "error")
    private String error;
}
