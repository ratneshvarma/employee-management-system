package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.CompanyDaoImpl;
import com.ratnesh.ems.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
   CompanyDaoImpl companyDao;
    public Boolean addBranch(Branch branch) {
        return companyDao.insertBranch(branch);
    }

    public List<Branch> getAllBranches() {
        return companyDao.getBranches();
    }

    public Boolean removeBranch(Branch branch) {
        return companyDao.deleteBranch(branch);
    }

    public Boolean editBranch(Branch branch) {
        return companyDao.updateBranch(branch);
    }

    public Branch branchForUpdate(Branch branch) {
        return companyDao.getBranchForUpdate(branch);
    }
}
