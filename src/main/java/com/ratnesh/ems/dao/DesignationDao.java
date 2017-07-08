package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.model.Designation;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
public interface DesignationDao {
    Boolean insertDesignation(Designation designation);
    List<Designation> getDesignations();
    Boolean deleteDesignation(Designation designation);
    Boolean updateDesignation(Designation designation);
    Designation getDesignationForUpdate(Designation designation);
}
