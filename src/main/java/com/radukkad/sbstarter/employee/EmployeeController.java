package com.radukkad.sbstarter.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class EmployeeController implements org.SwaggerCodeGenExample.api.EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<String> addEmployee(@Validated org.SwaggerCodeGenExample.model.Employee employee) {
        employeeService.add(employee);
        return ResponseEntity.ok("Employee with id "+employee.getId()+" is added");
    }

    @Override
    public ResponseEntity<List<org.SwaggerCodeGenExample.model.Employee>> getEmployees() {
        List<org.SwaggerCodeGenExample.model.Employee> employeeList = employeeService.getEmployees();
        return ResponseEntity.ok(employeeList);
    }
}