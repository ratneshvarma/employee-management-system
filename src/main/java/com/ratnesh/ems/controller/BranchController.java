package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/addBranch")
    public ModelAndView branchPage(){

        return new ModelAndView("branch/create","branch", new Branch());
    }

    @RequestMapping(value = "/saveBranch")
    public ModelAndView branchSave(@ModelAttribute("branch") Branch branch, RedirectAttributes redirectAttributes){

        String message=null;
        boolean insterted  = branchService.addBranch(branch);

        if(insterted)
            message = "Branch successfully added.";

        else
            message = "Insertion failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/branch/addBranch");
    }

    @RequestMapping("/viewAll")
    public ModelAndView dashboard(){
        List branchList = branchService.getAllBranches();
        return new ModelAndView("branch/index","branchList",branchList);
    }



    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") long branchId){
        Branch branch = new Branch();
        branch.setBranchId(branchId);
        branch= branchService.branchForUpdate(branch);

        ModelAndView modelAndView = new ModelAndView("branch/edit","branch", branch);

        return modelAndView;
    }

    @RequestMapping(value = "/updateBranch",method= RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute("branch") Branch branch, RedirectAttributes redirectAttributes){

        String message = null;
        boolean updated  = branchService.editBranch(branch);
        if(updated)
            message = "Branch updated.";

        else
            message = "Updation failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/branch/viewAll");
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long branchId, final RedirectAttributes redirectAttributes){
        Branch branch = new Branch();
        branch.setBranchId(branchId);
        branchService.removeBranch(branch);
        redirectAttributes.addFlashAttribute("message","Record deleted.");
        return new ModelAndView("redirect:/branch/viewAll");
    }
}
