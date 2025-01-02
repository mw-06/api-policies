package com.api.policies.modules.policy.domain.models;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.inventory.domain.models.Inventory;

import java.time.LocalDateTime;

public class Policy {
    private Integer idPolicy;
    private Employee employee;
    private Inventory inventory;
    private Integer quantity;
    private LocalDateTime dateTime;
    private Integer status;

    public Integer getIdPolicy() {
        return idPolicy;
    }

    public void setIdPolicy(Integer idPolicy) {
        this.idPolicy = idPolicy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
