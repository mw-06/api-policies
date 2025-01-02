package com.api.policies.modules.employee.infrastructure.adapters.out.persistence.repositories;

import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.infrastructure.adapters.out.persistence.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<EmployeeEntity> employeeRowMapper = (rs, rowNum) -> {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setIdEmployee(rs.getInt("id_employee"));
        employeeEntity.setFirstName(rs.getString("first_name"));
        employeeEntity.setMiddleName(rs.getString("middle_name"));
        employeeEntity.setLastName(rs.getString("last_name"));
        employeeEntity.setSecondLastName(rs.getString("second_last_name"));
        employeeEntity.setPosition(rs.getString("position"));

        return employeeEntity;
    };
    public List<EmployeeEntity> getEmployees() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("getEmployees")
                .returningResultSet("employees", employeeRowMapper);

        Map<String, Object> result = jdbcCall.execute();
        return (List<EmployeeEntity>) result.get("employees");
    }
    public EmployeeEntity getEmployeeById(Integer idEmployee) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("getEmployeeById")
                .declareParameters(
                        new SqlParameter("id", Types.INTEGER),
                        new SqlOutParameter("id_employee", Types.INTEGER),
                        new SqlOutParameter("first_name", Types.VARCHAR),
                        new SqlOutParameter("middle_name", Types.VARCHAR),
                        new SqlOutParameter("last_name", Types.VARCHAR),
                        new SqlOutParameter("second_last_name", Types.VARCHAR),
                        new SqlOutParameter("position", Types.VARCHAR)
                );

        Map<String, Object> result = jdbcCall.execute(idEmployee);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setIdEmployee((Integer) result.get("id_employee"));
        employeeEntity.setFirstName((String) result.get("first_name"));
        employeeEntity.setMiddleName((String) result.get("middle_name"));
        employeeEntity.setLastName((String) result.get("last_name"));
        employeeEntity.setSecondLastName((String) result.get("second_last_name"));
        employeeEntity.setPosition((String) result.get("position"));
        return employeeEntity;
    }

    public EmployeeEntity insertEmployee(EmployeeEntity employeeEntity) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("insertEmployee")
                .declareParameters(
                        new SqlParameter("first_name", Types.VARCHAR),
                        new SqlParameter("middle_name", Types.VARCHAR),
                        new SqlParameter("last_name", Types.VARCHAR),
                        new SqlParameter("second_last_name", Types.VARCHAR),
                        new SqlParameter("position", Types.VARCHAR),
                        new SqlOutParameter("id_employee", Types.INTEGER)  // Parámetro de salida para el ID generado
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("first_name", employeeEntity.getFirstName());
        inParams.put("middle_name", employeeEntity.getMiddleName());
        inParams.put("last_name", employeeEntity.getLastName());
        inParams.put("second_last_name", employeeEntity.getSecondLastName());
        inParams.put("position", employeeEntity.getPosition());

        // Ejecutar el sp
        Map<String, Object> result = jdbcCall.execute(inParams);

        Integer generatedId = (Integer) result.get("id_employee");

        employeeEntity.setIdEmployee(generatedId);
        return employeeEntity;
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("updateEmployee")
                .declareParameters(
                        new SqlParameter("id_employee", Types.INTEGER), // Parámetro de entrada para el ID
                        new SqlParameter("first_name", Types.VARCHAR),
                        new SqlParameter("middle_name", Types.VARCHAR),
                        new SqlParameter("last_name", Types.VARCHAR),
                        new SqlParameter("second_last_name", Types.VARCHAR),
                        new SqlParameter("position", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("id_employee", employeeEntity.getIdEmployee());
        inParams.put("first_name", employeeEntity.getFirstName());
        inParams.put("middle_name", employeeEntity.getMiddleName());
        inParams.put("last_name", employeeEntity.getLastName());
        inParams.put("second_last_name", employeeEntity.getSecondLastName());
        inParams.put("position", employeeEntity.getPosition());

        jdbcCall.execute(inParams);

        return employeeEntity;
    }

}

