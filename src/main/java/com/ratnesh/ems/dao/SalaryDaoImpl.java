package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Employee;
import com.ratnesh.ems.model.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
@Repository("salaryDao")
public class SalaryDaoImpl implements SalaryDao {
    @Autowired
    private SessionFactory sessionFactory;
    public Map getEmployeeList() {
        Session session = this.sessionFactory.getCurrentSession();
       List<Employee> employees=  session.createQuery("from Employee").list();
        Map<Integer, String> employeeList = new HashMap<Integer, String>();
        for (Employee emp: employees){
            employeeList.put(emp.getEmpId().intValue()," ("+emp.getEmpId()+") "+ emp.getFirstName()+" "+ emp.getLastName());
        }
        System.out.println("Employee List: "+ employeeList);
        return employeeList;

    }

    public Boolean insertSalary(Salary salary) {
        Session session=this.sessionFactory.getCurrentSession();
        session.save(salary);
        return true;
    }

    public List<Salary> getSalaries() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Salary> salaryList = session.createQuery("from Salary").list();
        return salaryList;
    }

    public Boolean deleteSalary(Salary salary) {
        Session session=this.sessionFactory.getCurrentSession();
        salary= (Salary) session.load(Salary.class, salary.getSalaryId());
        if(salary!=null)
            session.delete(salary);
        return true;
    }

    public Boolean updateSalary(Salary salary) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(salary);
        return true;
    }

    public Salary getSalaryForUpdate(Salary salary) {
        Session session=this.sessionFactory.getCurrentSession();
        Salary salary1= (Salary) session.get(Salary.class, salary.getSalaryId());
        return  salary1;
    }
}
