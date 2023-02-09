package com.radukkad.sbstarter.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    List<org.SwaggerCodeGenExample.model.Employee> getEmployees() {
        List<org.SwaggerCodeGenExample.model.Employee> retList = new ArrayList<org.SwaggerCodeGenExample.model.Employee>();
        Iterable<EmployeeModel> employees = employeeRepository.findAll();
        for (EmployeeModel employee: employees) {
            org.SwaggerCodeGenExample.model.Employee empDO = new org.SwaggerCodeGenExample.model.Employee();
            empDO.setId(employee.getId());
            empDO.setName(employee.getName());
            empDO.setAge(employee.getAge());
            retList.add(empDO);
        }
        return retList;
    }

    public void add(org.SwaggerCodeGenExample.model.Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setAge(employee.getAge());
        employeeModel.setName(employee.getName());
        employeeRepository.save(employeeModel);
    }


}
