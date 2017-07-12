package com.ratnesh.ems.model;


import javax.persistence.*;

/**
 * Created by ratnesh on 8/7/17.
 */
@Entity
@Table(name = "designation")
public class Designation {
    @Id
    @Column(name="designationId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long designationId;
    private String designation;
    private String description;

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
