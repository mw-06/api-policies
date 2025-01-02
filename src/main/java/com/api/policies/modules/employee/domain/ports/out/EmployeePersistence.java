package com.api.policies.modules.employee.domain.ports.out;

import com.api.policies.modules.employee.domain.models.Employee;

import java.util.List;

public interface EmployeePersistence {
    List<Employee> getEmployees();
    Employee getEmployeeByPk(Integer idEmployee);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
}
