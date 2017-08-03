package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.service.CompanyService;
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

/**
 * Created by ratnesh on 8/7/17.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/addBranch")
    public ModelAndView branchPage(){

        return new ModelAndView("company/create","branch", new Branch());
    }

    @RequestMapping(value = "/saveBranch")
    public ModelAndView branchSave(@ModelAttribute("branch") Branch branch, RedirectAttributes redirectAttributes){

        String message=null;
        boolean insterted  = companyService.addBranch(branch);

        if(insterted)
            message = "Branch successfully added.";

        else
            message = "Insertion failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/company/addBranch");
    }

    @RequestMapping("/viewAll")
    public ModelAndView dashboard(){
        List branchList = companyService.getAllBranches();
        return new ModelAndView("company/index","branchList",branchList);
    }



    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") long branchId){
        Branch branch = new Branch();
        branch.setBranchId(branchId);
        branch= companyService.branchForUpdate(branch);

        ModelAndView modelAndView = new ModelAndView("company/edit","branch", branch);

        return modelAndView;
    }

    @RequestMapping(value = "/updateBranch",method= RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute("branch") Branch branch, RedirectAttributes redirectAttributes){

        String message = null;
        boolean updated  = companyService.editBranch(branch);
        if(updated)
            message = "Branch updated.";

        else
            message = "Updation failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/company/viewAll");
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long branchId, final RedirectAttributes redirectAttributes){
        Branch branch = new Branch();
        branch.setBranchId(branchId);
        companyService.removeBranch(branch);
        redirectAttributes.addFlashAttribute("message","Record deleted.");
        return new ModelAndView("redirect:/company/viewAll");
    }
}
