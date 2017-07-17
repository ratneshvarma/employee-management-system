package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.DesignationDao;
import com.ratnesh.ems.dao.DesignationDaoImpl;
import com.ratnesh.ems.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Service
public class DesignationServiceImpl  implements  DesignationService{

    private DesignationDao designationDao;
    public void setDesignationDao(DesignationDao designationDao) {
        this.designationDao = designationDao;
    }

    @Transactional
    public Boolean addDesignation(Designation designation) {
        return this.designationDao.insertDesignation(designation);
    }
    @Transactional
    public List<Designation> getAllDesignations() {
        return this.designationDao.getDesignations();
    }
    @Transactional
    public Boolean removeDesignation(Designation designation) {
        return this.designationDao.deleteDesignation(designation);
    }
    @Transactional
    public Boolean editDesignation(Designation designation) {
        return this.designationDao.updateDesignation(designation);
    }
    @Transactional
    public Designation designationForUpdate(Designation designation) {
        return this.designationDao.getDesignationForUpdate(designation);
    }
}
