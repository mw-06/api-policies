package com.api.policies.modules.employee.infrastructure.services;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.domain.ports.out.EmployeePersistence;
import com.api.policies.modules.employee.domain.services.EmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeePersistence employeePersistence;

    @Override
    public List<Employee> getEmployees() {
        return employeePersistence.getEmployees();
    }

    @Override
    public Employee getEmployeeByPk(Integer idEmployee) {
        return employeePersistence.getEmployeeByPk(idEmployee);
    }

    @SneakyThrows
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeePersistence.saveEmployee(employee);
    }

    @SneakyThrows
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeePersistence.updateEmployee(employee);
    }
}

