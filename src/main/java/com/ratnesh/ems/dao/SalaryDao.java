package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Salary;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
public interface SalaryDao {
    Map getEmployeeList();
    Boolean insertSalary(Salary salary);
    List<Salary> getSalaries();
    Boolean deleteSalary(Salary salary);
    Boolean updateSalary(Salary salary);
    Salary getSalaryForUpdate(Salary salary);
}
