package com.ratnesh.ems.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ratnesh on 10/7/17.
 */
@Entity
@Table(name = "salary")
public class Salary {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;

    //private Long empId;
    private Long salary;
    private String description;
    private String paymentDate;
    @Transient
    private String employeeName;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name="empId")
    private Employee employee;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

//    public Long getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Long empId) {
//        this.empId = empId;
//    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
