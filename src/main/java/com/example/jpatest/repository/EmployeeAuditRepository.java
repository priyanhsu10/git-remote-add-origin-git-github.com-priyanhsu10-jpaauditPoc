package com.example.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpatest.entities.EmployeeAudit;

@Repository
public interface EmployeeAuditRepository extends JpaRepository<EmployeeAudit, Integer> {

}
