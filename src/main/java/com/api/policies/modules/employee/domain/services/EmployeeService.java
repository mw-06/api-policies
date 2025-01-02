package com.api.policies.modules.employee.domain.services;

import com.api.policies.modules.employee.domain.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeByPk(Integer idEmployee);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);

}
