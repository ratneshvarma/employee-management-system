package com.ratnesh.ems.service;

import com.ratnesh.ems.model.Salary;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
public interface SalaryService {
    Map allEmployeeList();
    Boolean addSalary(Salary salary);
    List<Salary> getAllSalaries();
    Boolean removeSalary(Salary salary);
    Boolean editSalary(Salary salary);
    Salary salaryForUpdate(Salary salary);
}
