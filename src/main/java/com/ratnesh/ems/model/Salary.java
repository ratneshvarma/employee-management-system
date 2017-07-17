package com.ratnesh.ems.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by ratnesh on 10/7/17.
 */
@Entity
@Table(name = "salary")
public class Salary {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    @OneToMany
    @ForeignKey(name = "fk_employee")
    private Employee empId;
//    private Long empId;
    private Long salary;
    private String description;
    private String paymentDate;
    private String employeeName;

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

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
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
