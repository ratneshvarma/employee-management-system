package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.EmployeeDao;
import com.ratnesh.ems.dao.EmployeeDaoImpl;
import com.ratnesh.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by ratnesh on 31/5/17.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public Map branchList() {
        return employeeDao.getBranches();
    }
    @Transactional
    public Map designationList() {
        return employeeDao.getDesignation();
    }
    @Transactional
    public Boolean employeeInsert(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }
    @Autowired
    ServletContext context;
    public Boolean uploadImage(MultipartFile multipartFile, Employee employee)  {
        try {

            String path = context.getRealPath("/employee_pictures") + File.separator + multipartFile.getOriginalFilename();
            String destinationPath = context.getRealPath("/employee_pictures") + File.separator;
            File destinationFile = new File(path);

            if(!destinationFile.exists()) {
                destinationFile.mkdirs();

            }

            String fileExtention[] = employee.getPhoto().getOriginalFilename().split("\\.");
            String photoName =  employee.getFirstName() +"_"+employee.getEmpId()+ "." + fileExtention[1];

            File destinationFileRenamed = new File(destinationPath + photoName);

            multipartFile.transferTo(destinationFile);
            destinationFile.renameTo(destinationFileRenamed);
        }catch (Exception e){

        }
        return true;
    }
    @Transactional
    public List<Employee> allEmployees() {
        return employeeDao.getEmployees();
    }
    @Transactional
    public Boolean employeeDelete(Employee employee) {
        return employeeDao.deleteEmployee(employee);
    }
    @Transactional
    public Employee getEmployeeForUpdate(Employee employee) {
        return employeeDao.getEmployeeForUpdate(employee);
    }
    @Transactional//(readOnly = true)
    public Boolean employeeUpdate(Employee employee) {
         return employeeDao.updateEmployee(employee);
    }
}
