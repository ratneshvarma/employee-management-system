package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Designation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
@Repository
public class DesignationDaoImpl implements  DesignationDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Boolean insertDesignation(final Designation designation) {
        Session session=this.sessionFactory.getCurrentSession();
        session.save(designation);
        return true;
    }
    public List<Designation> getDesignations() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Designation>designationList = session.createQuery("from Designation").list();
//        for(Designation designation : designationList){
//            System.out.println("Person List::"+designation);
//        }

        return designationList;

    }

    public Boolean deleteDesignation(Designation designation) {
        Session session=this.sessionFactory.getCurrentSession();
        designation= (Designation) session.load(Designation.class, designation.getDesignationId());
        if(designation!=null)
        session.delete(designation);
        return true;
    }

    public Boolean updateDesignation(Designation designation) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(designation);
        return true;
    }

    public Designation getDesignationForUpdate(Designation designation) {
        Session session=this.sessionFactory.getCurrentSession();
        Designation designation1= (Designation) session.get(Designation.class, designation.getDesignationId());
       return  designation1;
    }

}
