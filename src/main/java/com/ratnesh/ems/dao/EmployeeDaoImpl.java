package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.model.Designation;
import com.ratnesh.ems.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;
    public Map getBranches() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Branch> branches=  session.createQuery("from Branch").list();
        Map<Integer, String> branchList = new HashMap<Integer, String>();
        for (Branch branch: branches){
            branchList.put(branch.getBranchId().intValue(), branch.getName());
        }
        System.out.println("Branch List: "+ branchList);
        return branchList;
    }

    public Map getDesignation() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Designation> designations=  session.createQuery("from Designation").list();
        Map<Integer, String> designationList = new HashMap<Integer, String>();
        for (Designation designation: designations){
            designationList.put(designation.getDesignationId().intValue(), designation.getDescription());
        }
        System.out.println("Designa List: "+ designationList);
        return designationList;
    }

    public Boolean insertEmployee(Employee employee) {
        Session session=this.sessionFactory.getCurrentSession();
        session.save(employee);
        return true;
    }

    public List<Employee> getEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        return employeeList;
    }

    public Boolean deleteEmployee(Employee employee) {
        Session session=this.sessionFactory.getCurrentSession();
        employee= (Employee) session.load(Employee.class, employee.getEmpId());
        if(employee!=null)
            session.delete(employee);
        return true;
    }

    public Employee getEmployeeForUpdate(Employee employee) {
        Session session=this.sessionFactory.getCurrentSession();
        Employee employee1= (Employee) session.get(Employee.class, employee.getEmpId());
        return  employee1;
    }

    public Boolean updateEmployee(Employee employee) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(employee);
        return true;
    }



}
