package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Repository
public class CompanyDaoImpl implements  CompanyDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Boolean insertBranch(Branch branch) {
        Session session=this.sessionFactory.getCurrentSession();
        session.save(branch);
        return true;

    }

    public List<Branch> getBranches() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Branch>designationList = session.createQuery("from Branch").list();
        return designationList;
    }

    public Boolean deleteBranch(Branch branch) {
        Session session=this.sessionFactory.getCurrentSession();
        branch= (Branch) session.load(Branch.class, branch.getBranchId());
        if(branch!=null)
            session.delete(branch);
        return true;
    }

    public Boolean updateBranch(Branch branch) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(branch);
        return true;
    }

    public Branch getBranchForUpdate(Branch branch) {
        Session session=this.sessionFactory.getCurrentSession();
        Branch branch1= (Branch) session.get(Branch.class, branch.getBranchId());
        return  branch1;
    }

}
