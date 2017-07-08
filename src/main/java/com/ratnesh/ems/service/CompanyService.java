package com.ratnesh.ems.service;

import com.ratnesh.ems.model.Branch;

import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
public interface CompanyService {
    Boolean addBranch(Branch branch);
    List<Branch> getAllBranches();
    Boolean removeBranch(Branch branch);
    Boolean editBranch(Branch branch);
    Branch branchForUpdate(Branch branch);
}
