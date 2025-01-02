package com.api.policies.modules.inventory.infrastructure.adapters.out.persistence.entities;

import com.api.policies.modules.policy.infrastructure.adapters.out.persistence.entities.PolicyEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity()
@Table(name = "inventory_inventories")
@Getter
@Setter
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventory")
    private Integer idInventory;

    @Column(name = "sku", nullable = false, length = 100, unique = true)
    private String sku;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "inventory", cascade = {CascadeType.MERGE})
    private Set<PolicyEntity> policies;
}
