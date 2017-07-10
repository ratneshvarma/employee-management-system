package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.SalaryDaoImpl;
import com.ratnesh.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryDaoImpl salaryDao;
    public Map allEmployeeList() {
        return salaryDao.getEmployeeList();
    }

    public Boolean addSalary(Salary salary) {
        return salaryDao.insertSalary(salary);
    }

    public List<Salary> getAllSalaries() {
        return salaryDao.getSalaries();
    }

    public Boolean removeSalary(Salary salary) {
        return salaryDao.deleteSalary(salary);
    }

    public Boolean editSalary(Salary salary) {
        return salaryDao.updateSalary(salary);
    }

    public Salary salaryForUpdate(Salary salary) {
        return salaryDao.getSalaryForUpdate(salary);
    }
}
