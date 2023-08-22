package com.example.jpatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpatest.dtos.InputRequest;
import com.example.jpatest.entities.Employee;
import com.example.jpatest.repository.EmployeeRepository;
import com.example.jpatest.service.EmployeeServce;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeServce service;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody InputRequest<Employee> request) {
        return service.saveEmployee(request);
    }

    @PutMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary,
            @RequestBody InputRequest<Employee> request) {
        return service.updateEmployee(id, salary, request);
    }

}
