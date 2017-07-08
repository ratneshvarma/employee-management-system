package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.DesignationDaoImpl;
import com.ratnesh.ems.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Service
public class DesignationServiceImpl  implements  DesignationService{
    @Autowired
    DesignationDaoImpl designationDao;
    public Boolean addDesignation(Designation designation) {
        return designationDao.insertDesignation(designation);
    }

    public List<Designation> getAllDesignations() {
        return designationDao.getDesignations();
    }

    public Boolean removeDesignation(Designation designation) {
        return designationDao.deleteDesignation(designation);
    }

    public Boolean editDesignation(Designation designation) {
        return designationDao.updateDesignation(designation);
    }

    public Designation designationForUpdate(Designation designation) {
        return designationDao.getDesignationForUpdate(designation);
    }
}
