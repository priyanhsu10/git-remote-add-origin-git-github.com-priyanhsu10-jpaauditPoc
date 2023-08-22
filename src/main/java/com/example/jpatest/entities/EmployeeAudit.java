package com.example.jpatest.entities;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tblEmpAudit")
public class EmployeeAudit {
    @GeneratedValue
    @Id
    private int id;
    private int empid;
    private String name;
    private String dept;
    private double salary;

    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    private String createdBy;
    private String modifiedBy;

    public EmployeeAudit(Employee e) {
        this.empid = e.getId();
        this.name = e.getName();
        this.salary = e.getSalary();
        this.createDate = e.getCreateDate();
        this.lastModifiedDate = e.getLastModifiedDate();
        this.createdBy = e.getCreatedBy();
        this.modifiedBy = e.getModifiedBy();
    }
}
