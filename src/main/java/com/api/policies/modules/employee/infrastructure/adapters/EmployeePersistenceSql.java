package com.api.policies.modules.employee.infrastructure.adapters;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.domain.ports.out.EmployeePersistence;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.entities.EmployeeEntity;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.mappers.EmployeeMapper;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePersistenceSql implements EmployeePersistence {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> entities = employeeRepository.getEmployees();
        return employeeMapper.toModelList(entities);
    }

    @Override
    public Employee getEmployeeByPk(Integer idEmployee) {
        EmployeeEntity employeeEntity = employeeRepository.getEmployeeById(idEmployee);
        return employeeMapper.entityToModel(employeeEntity);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeMapper.modelToEntity(employee);
        employeeEntity = employeeRepository.insertEmployee(employeeEntity);
        employee = employeeMapper.entityToModel(employeeEntity);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeMapper.modelToEntity(employee);
        employeeEntity = employeeRepository.updateEmployee(employeeEntity);
        employee = employeeMapper.entityToModel(employeeEntity);
        return employee;
    }
}

