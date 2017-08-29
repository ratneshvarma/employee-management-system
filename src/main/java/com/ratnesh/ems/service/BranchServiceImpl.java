package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.BranchDao;
import com.ratnesh.ems.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDao branchDao;
    @Transactional
    public Boolean addBranch(Branch branch) {
        return this.branchDao.insertBranch(branch);
    }
    @Transactional
    public List<Branch> getAllBranches() {
        return this.branchDao.getBranches();
    }
    @Transactional
    public Boolean removeBranch(Branch branch) {
        return this.branchDao.deleteBranch(branch);
    }
    @Transactional
    public Boolean editBranch(Branch branch) {
        return this.branchDao.updateBranch(branch);
    }
    @Transactional
    public Branch branchForUpdate(Branch branch) {
        return this.branchDao.getBranchForUpdate(branch);
    }
}
