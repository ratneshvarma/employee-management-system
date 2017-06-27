package com.ratnesh.ems.service;

import com.ratnesh.ems.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */
public interface EmployeeService {
    Map branchList();
    Map designationList();
    Integer maxEmployeeId();
    Boolean employeeInsert(Employee employee);
    Boolean uploadImage(MultipartFile multipartFile, Employee employee);
    List<Employee> allEmployees();
    Boolean employeeDelete(Employee employee);
}
