package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.CompanyDao;
import com.ratnesh.ems.dao.CompanyDaoImpl;
import com.ratnesh.ems.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    private CompanyDao companyDao;
    @Transactional
    public Boolean addBranch(Branch branch) {
        return this.companyDao.insertBranch(branch);
    }
    @Transactional
    public List<Branch> getAllBranches() {
        return this.companyDao.getBranches();
    }
    @Transactional
    public Boolean removeBranch(Branch branch) {
        return this.companyDao.deleteBranch(branch);
    }
    @Transactional
    public Boolean editBranch(Branch branch) {
        return this.companyDao.updateBranch(branch);
    }
    @Transactional
    public Branch branchForUpdate(Branch branch) {
        return this.companyDao.getBranchForUpdate(branch);
    }
}
