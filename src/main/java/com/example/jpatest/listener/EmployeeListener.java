package com.example.jpatest.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpatest.entities.Employee;
import com.example.jpatest.entities.EmployeeAudit;
import com.example.jpatest.repository.EmployeeAuditRepository;

import jakarta.persistence.PostPersist;

@Component
public class EmployeeListener {

    private final EmployeeAuditRepository auditRepository;

    public EmployeeListener(@Lazy EmployeeAuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @PostPersist
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAudit(Employee e) {

        EmployeeAudit empAudit = new EmployeeAudit(e);
        auditRepository.save(empAudit);
        System.out.println("udpate callled ");
    }
}
