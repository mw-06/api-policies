package com.api.policies.modules.employee.domain.ports.in;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.employee.domain.models.Employee;

public interface EmployeeRest {
    Response getEmployees();
    Response getEmployeeById(Integer idEmployee);
    Response saveEmployee(Employee employee);
    Response updateEmployee(Employee employee);
}
