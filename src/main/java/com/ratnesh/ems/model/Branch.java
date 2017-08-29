package com.ratnesh.ems.model;

import javax.persistence.*;

/**
 * Created by ratnesh on 8/7/17.
 */
@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "branchId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long branchId;
    private String name;
    private String address;

    @Override
    public String toString() {
        return  name;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
