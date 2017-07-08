package com.ratnesh.ems.service;

import com.ratnesh.ems.model.Designation;
import com.ratnesh.ems.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */

public interface DesignationService {
    Boolean addDesignation(Designation designation);
    List<Designation> getAllDesignations();
    Boolean removeDesignation(Designation designation);
    Boolean editDesignation(Designation designation);
    Designation designationForUpdate(Designation designation);
}
