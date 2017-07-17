package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Designation;
import com.ratnesh.ems.service.DesignationService;
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
@RequestMapping("/designation")
public class DesignationController {
    @Autowired(required=true)
    @Qualifier(value="designationService")
    private DesignationService designationService;

    public void setDesignationService(DesignationService designationService) {
        this.designationService = designationService;
    }

    @RequestMapping(value = "/addDesignation")
    public ModelAndView designationPage(){

        return new ModelAndView("designation/create","designation", new Designation());
    }

    @RequestMapping(value = "/saveDesignation")
    public ModelAndView designationSave(@ModelAttribute("designation") Designation designation, RedirectAttributes redirectAttributes){
        System.out.println("Service: "+this.designationService);
        String message=null;
        boolean insterted  =this.designationService.addDesignation(designation);

        if(insterted)
            message = "Designation successfully added.";

        else
            message = "Insertion failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/designation/addDesignation");
    }

    @RequestMapping("/viewAll")
    public ModelAndView dashboard(){
        List designationList = this.designationService.getAllDesignations();
        return new ModelAndView("designation/index","designationList",designationList);
    }



    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id") long designationId){
        Designation designation= new Designation();
        designation.setDesignationId(designationId);
        designation= this.designationService.designationForUpdate(designation);

        ModelAndView modelAndView = new ModelAndView("designation/edit","designation", designation);

        return modelAndView;
    }

    @RequestMapping(value = "/updateDesignation",method= RequestMethod.POST)
    public ModelAndView updateDesignation(@ModelAttribute("designation") Designation designation, RedirectAttributes redirectAttributes){

        String message = null;
        boolean updated  = this.designationService.editDesignation(designation);
        if(updated)
            message = "Designation updated.";

        else
            message = "Updation failed, please retry.";

        redirectAttributes.addFlashAttribute("message",message);
        return new ModelAndView("redirect:/designation/viewAll");
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") long designationId, final RedirectAttributes redirectAttributes){
        Designation designation = new Designation();
        designation.setDesignationId(designationId);
        this.designationService.removeDesignation(designation);
        redirectAttributes.addFlashAttribute("message","Record deleted.");
        return new ModelAndView("redirect:/designation/viewAll");
    }
}
