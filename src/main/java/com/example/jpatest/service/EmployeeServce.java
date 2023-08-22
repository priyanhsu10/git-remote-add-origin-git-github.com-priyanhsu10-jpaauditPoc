package com.example.jpatest.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpatest.dtos.InputRequest;
import com.example.jpatest.entities.Employee;
import com.example.jpatest.repository.EmployeeRepository;
//     {"userId": "priyanshu",
//    "employee":{
//     "name":"Shweta",
//     "doj":"17/04/2017",
//     "dept":"banking",
//     "salary":50000

//    }}

@Service
public class EmployeeServce {

    @Autowired
    private EmployeeRepository repository;

    public String saveEmployee(InputRequest<Employee> request) {
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee = request.getEmployee();
        employee.setCreatedBy(currentUser);
        repository.save(employee);
        return "Employee saved successfully...";

    }

    public String updateEmployee(int id, double salary, InputRequest<Employee> request) {
        Employee employee = repository.findById(id).get();
        if (employee != null) {
            employee.setSalary(salary);
            employee.setModifiedBy(request.getLoggedInUser());
            repository.saveAndFlush(employee);
        } else {
            throw new RuntimeException("Employee not found with id : " + id);
        }
        return "Employee Updated successfully ";
    }

}
