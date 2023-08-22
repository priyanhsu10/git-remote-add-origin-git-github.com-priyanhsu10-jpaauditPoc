package com.example.jpatest.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.jpatest.listener.EmployeeListener;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(value = { AuditingEntityListener.class, EmployeeListener.class })

@Table(name = "tblEmployee")
public class Employee {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String dept;
    private double salary;

    @CreatedDate
    private LocalDate createDate;
    @LastModifiedDate
    private LocalDate lastModifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;

}
