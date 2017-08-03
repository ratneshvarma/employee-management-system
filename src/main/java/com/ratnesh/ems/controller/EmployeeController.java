package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Employee;
import com.ratnesh.ems.service.EmployeeService;
import com.ratnesh.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

/**
 * Created by ratnesh on 30/5/17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/login")
    public ModelAndView test(){
        List employeeList = employeeService.allEmployees();
        return new ModelAndView("employee/index","employeeList",employeeList);
    }
    @RequestMapping("/home")
    public ModelAndView dashboard(){
        List employeeList = employeeService.allEmployees();
        return new ModelAndView("employee/index","employeeList",employeeList);
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

        ModelAndView modelAndView = new ModelAndView("employee/create","employee", new Employee());
        modelAndView.addObject("genderList", genderList);
        modelAndView.addObject("maritalList",maritalList);
        modelAndView.addObject("branchList",branchList);
        modelAndView.addObject("designationList", designationList);
//        modelAndView.addObject("maxEployeeId", employeeService.maxEmployeeId()+1 );

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

        boolean inserted  = employeeService.employeeInsert(employee);

        if(inserted)
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

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") long empId){
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
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee = employeeService.getEmployeeForUpdate(employee);

        ModelAndView modelAndView = new ModelAndView("employee/edit","employee", employee);
        modelAndView.addObject("genderList", genderList);
        modelAndView.addObject("maritalList",maritalList);
        modelAndView.addObject("branchList",branchList);
        modelAndView.addObject("designationList", designationList);

        return modelAndView;
    }

    @RequestMapping(value = "/updateEmployee",method=RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestParam("photo") MultipartFile file, @ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        boolean fileSaveFlag = employeeService.uploadImage(file, employee);

        String message = null;
        boolean updated  = employeeService.employeeUpdate(employee);
        if(updated)
            message = "Employee successfully updated.";

        else
            message = "Updation failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/employee/home");
    }

}
