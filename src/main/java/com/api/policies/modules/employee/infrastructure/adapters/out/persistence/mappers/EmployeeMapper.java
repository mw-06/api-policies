package com.api.policies.modules.employee.infrastructure.adapters.out.persistence.mappers;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.entities.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeMapper {
    public Employee entityToModel(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
//        employee.setIdEmployee(employeeEntity.getIdEmployee());
//        employee.setFirstName(employeeEntity.getFirstName());
//        employee.setMiddleName(employeeEntity.getMiddleName());
//        employee.setLastName(employeeEntity.getLastName());
//        employee.setSecondLastName(employeeEntity.getSecondLastName());
//        employee.setPosition(employeeEntity.getPosition());
        return employee;
    }

    public EmployeeEntity modelToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
//        employeeEntity.setIdEmployee(employee.getIdEmployee());
//        employeeEntity.setFirstName(employee.getFirstName());
//        employeeEntity.setMiddleName(employee.getMiddleName());
//        employeeEntity.setLastName(employee.getLastName());
//        employeeEntity.setSecondLastName(employee.getSecondLastName());
//        employeeEntity.setPosition(employee.getPosition());
        return employeeEntity;
    }

    public List<Employee> toModelList(List<EmployeeEntity> employeeEntities) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities){
            Employee employee =  entityToModel(employeeEntity);
            employees.add(employee);
        }
        return employees;
    }

    public Set<EmployeeEntity> toEntityList(Set<Employee> employees ) {
        Set<EmployeeEntity> employeeEntities = new HashSet<>();
        for ( Employee employee : employees) {
            EmployeeEntity employeeEntity = modelToEntity(employee);
            employeeEntities.add(employeeEntity);
        }
        return employeeEntities;
    }
}