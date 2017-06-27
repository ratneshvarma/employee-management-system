package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */
public interface EmployeeDao {
    Map getBranches();
    Map getDesignation();
    Integer getEmployeeId();
    Boolean insertEmployee(Employee employee);
    List<Employee> getEmployees();
    Boolean deleteEmployee(Employee employee);
}
