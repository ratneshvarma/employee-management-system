package com.ratnesh.ems.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by ratnesh on 30/5/17.
 */
@Entity
@Table(name = "employee")
public class Employee {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String maritalStatus;
    private String dob;
    @OneToOne
    @JoinColumn(name="designationId")
    private Designation designation;
    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    private String address;
    private String mobile;
    private int age;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    //    private Long branchId;
    @OneToOne
    @JoinColumn(name="branchId")
    private Branch branch;

    @Transient
    private MultipartFile photo;
    @Column(name = "photo")
    private String imageName;
    private String doj;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long empId;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return firstName + " "+ lastName;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }


    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }



    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }


//    public Long getBranchId() {
//        return branchId;
//    }
//
//    public void setBranchId(Long branchId) {
//        this.branchId = branchId;
//    }

    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
