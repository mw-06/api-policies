package com.api.policies.modules.policy.infrastructure.adapters.out.persistence.entities;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.entities.EmployeeEntity;
import com.api.policies.modules.inventory.domain.models.Inventory;
import com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities.InventoryEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@NamedEntityGraph(
        name= "policy.graph",
        attributeNodes = {@NamedAttributeNode(value = "employee"),  @NamedAttributeNode( value = "inventory" )}
)
@Entity()
@Table(name = "policy_policies")
@Getter
@Setter
public class PolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_policy")
    private Integer idPolicy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_employee", nullable = false )
    private EmployeeEntity employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_inventory", nullable = false )
    private InventoryEntity inventory;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "status")
    private Integer status;
}
