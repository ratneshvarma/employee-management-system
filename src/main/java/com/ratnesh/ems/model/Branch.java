package com.ratnesh.ems.model;

/**
 * Created by ratnesh on 8/7/17.
 */
public class Branch {

    private Long branchId;
    private String name;
    private String address;

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
