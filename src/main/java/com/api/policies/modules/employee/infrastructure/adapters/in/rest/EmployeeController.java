package com.api.policies.modules.employee.infrastructure.adapters.in.rest;

import com.api.policies.infrastructure.response.Response;
import com.api.policies.modules.core.domain.models.Log;
import com.api.policies.modules.core.domain.services.LogService;
import com.api.policies.modules.employee.domain.models.Employee;
import com.api.policies.modules.employee.domain.ports.in.EmployeeRest;
import com.api.policies.modules.employee.domain.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController implements EmployeeRest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LogService logService;

    @GetMapping("/check")
    public String index() {
        return "CONECTADO";
    }


    @Override
    @GetMapping("")
    public Response getEmployees() {
        try {
            List<Employee> employees = employeeService.getEmployees();
            return Response.ok(employees);
        } catch( Exception e ){
            Log log = new Log();
            log.setError("getEmployees - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener los registros.", e.getMessage());
        }
    }

    @Override
    @GetMapping("/{idEmployee}")
    public Response getEmployeeById(@PathVariable Integer idEmployee) {
        try {
            Employee employee = employeeService.getEmployeeByPk(idEmployee);
            return Response.ok(employee);
        } catch( Exception e ) {
            Log log = new Log();
            log.setError("getEmployeeById - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al obtener el registro.", e.getMessage());
        }
    }

    @Override
    @PostMapping()
    public Response saveEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeService.saveEmployee(employee);
            return Response.ok(employeeSaved);
        } catch( Exception e ) {
            Log log = new Log();
            log.setError("saveEmployee - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al guardar el registro.", e.getMessage());
        }
    }

    @Override
    @PutMapping()
    public Response updateEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeService.updateEmployee(employee);
            return Response.ok(employeeSaved);
        } catch( Exception e ) {
            Log log = new Log();
            log.setError("updateEmployee - " + e.getMessage());
            logService.saveLog(log);
            return Response.failure("Ocurrió un error al actualizar el registro.", e.getMessage());
        }
    }
}
