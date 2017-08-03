package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.SalaryDao;
import com.ratnesh.ems.dao.SalaryDaoImpl;
import com.ratnesh.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

   @Autowired
    private SalaryDao salaryDao;

    @Transactional
    public Map allEmployeeList() {
        return this.salaryDao.getEmployeeList();
    }
    @Transactional
    public Boolean addSalary(Salary salary) {
        return this.salaryDao.insertSalary(salary);
    }
    @Transactional
    public List<Salary> getAllSalaries() {
        return this.salaryDao.getSalaries();
    }
    @Transactional
    public Boolean removeSalary(Salary salary) {
        return this.salaryDao.deleteSalary(salary);
    }
    @Transactional
    public Boolean editSalary(Salary salary) {
        return this.salaryDao.updateSalary(salary);
    }
    @Transactional
    public Salary salaryForUpdate(Salary salary) {
        return this.salaryDao.getSalaryForUpdate(salary);
    }
}
