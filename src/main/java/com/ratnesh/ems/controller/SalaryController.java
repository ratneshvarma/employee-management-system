package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Designation;
import com.ratnesh.ems.model.Salary;
import com.ratnesh.ems.service.DesignationServiceImpl;
import com.ratnesh.ems.service.SalaryService;
import com.ratnesh.ems.service.SalaryServiceImpl;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 8/7/17.
 */
@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/addSalary")
    public ModelAndView salaryPage(){

        Map<Integer, String> employeeList = salaryService.allEmployeeList();
        ModelAndView modelAndView = new ModelAndView("salary/create","salary", new Salary());
        modelAndView.addObject("employeeList", employeeList);

        return modelAndView;
    }

    @RequestMapping(value = "/saveSalary")
    public ModelAndView salarySave(@ModelAttribute("salary") Salary salary, RedirectAttributes redirectAttributes){
        System.out.println("save sal");
        String message=null;
        boolean inserted  = salaryService.addSalary(salary);

        if(inserted)
            message = "Salary successfully added.";

        else
            message = "Insertion failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
       return new ModelAndView("redirect:/salary/addSalary");
    }

    @RequestMapping("/viewAll")
    public ModelAndView dashboard(){
        List salaryList = salaryService.getAllSalaries();
        return new ModelAndView("salary/index","salaryList",salaryList);

    }



    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") long salaryId){
        Salary salary= new Salary();
        salary.setSalaryId(salaryId);
        salary= salaryService.salaryForUpdate(salary);
        Map<Integer, String> employeeList = salaryService.allEmployeeList();
        ModelAndView modelAndView = new ModelAndView("salary/edit","salary", salary);
        modelAndView.addObject("employeeList",employeeList);
        return modelAndView;
    }

    @RequestMapping(value = "/updateSalary",method= RequestMethod.POST)
    public ModelAndView updateSalary(@ModelAttribute("salary") Salary salary, RedirectAttributes redirectAttributes){

        String message = null;
        boolean updated  = salaryService.editSalary(salary);
        if(updated)
            message = "Salary updated.";

        else
            message = "Updation failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/salary/viewAll");
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long salaryId, final RedirectAttributes redirectAttributes){
        Salary salary = new Salary();
        salary.setSalaryId(salaryId);
        salaryService.removeSalary(salary);
        redirectAttributes.addFlashAttribute("message","Record deleted.");
        return new ModelAndView("redirect:/salary/viewAll");
    }
}
