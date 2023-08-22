package com.example.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpatest.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}