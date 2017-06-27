package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Employee;
import com.ratnesh.ems.model.FileInfo;
import com.ratnesh.ems.service.EmployeeServiceImpl;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by ratnesh on 30/5/17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    Employee employee;
    @RequestMapping("/login")
    public ModelAndView test(){
        List employeeList = employeeService.allEmployees();
        return new ModelAndView("home","employeeList",employeeList);
    }
    @RequestMapping("/home")
    public ModelAndView dashboard(){
        List employeeList = employeeService.allEmployees();
        return new ModelAndView("home","employeeList",employeeList);
    }

    @RequestMapping("/addNewEmployee")
    public ModelAndView add(){
       List genderList = new ArrayList();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Other");

        List<String> maritalList = new ArrayList<String>();
        maritalList.add("Married");
        maritalList.add("Unmarried");
        maritalList.add("Other");

        Map<Integer, String> branchList = employeeService.branchList();
        Map<Integer, String> designationList = employeeService.designationList();

        ModelAndView modelAndView = new ModelAndView("newEmployee","employee", new Employee());
        modelAndView.addObject("genderList", genderList);
        modelAndView.addObject("maritalList",maritalList);
        modelAndView.addObject("branchList",branchList);
        modelAndView.addObject("designationList", designationList);
        modelAndView.addObject("maxEployeeId", employeeService.maxEmployeeId()+1 );

        return modelAndView;
    }

    @RequestMapping(value = "/newEmployeeSave",method=RequestMethod.POST)
    public ModelAndView saveEmployee(@RequestParam("photo") MultipartFile file, @ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        boolean fileSaveFlag = employeeService.uploadImage(file, employee);

        String message = null;
        String message_part=null;
//        if(fileSaveFlag)
//            message_part="Employee picture stored successfully.";
//        else
//            message_part="Employee picture not stored.";

        boolean insterted  = employeeService.employeeInsert(employee);

        if(insterted)
            message = "Employee successfully inserted.";

        else
            message = "Insertion failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
       return new ModelAndView("redirect:/employee/addNewEmployee");
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long empId, final RedirectAttributes redirectAttributes){
      Employee employee = new Employee();
        employee.setEmpId(empId);
        employeeService.employeeDelete( employee );
        redirectAttributes.addFlashAttribute("message","Record deleted.");
        return new ModelAndView("redirect:/employee/home");
    }

}
