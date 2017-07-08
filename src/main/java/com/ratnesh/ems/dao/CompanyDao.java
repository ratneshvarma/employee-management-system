package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
public interface CompanyDao {
    Boolean insertBranch(Branch branch);
    List<Branch> getBranches();
    Boolean deleteBranch(Branch branch);
    Boolean updateBranch(Branch branch);
    Branch getBranchForUpdate(Branch branch);
}
