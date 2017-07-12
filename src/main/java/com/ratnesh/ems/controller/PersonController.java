package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Person;
import com.ratnesh.ems.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ratnesh on 12/7/17.
 */
@Controller
@RequestMapping("/per")
public class PersonController {

    private PersonService personService;

    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

    @RequestMapping(value= "/persons", method= RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person/person";
    }

    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.GET)
    public String addPerson(@ModelAttribute("person") Person p){

//        if(p.getId() == 0){
//            //new person, add it
//            this.personService.addPerson(p);
//        }else{
//            //existing person, call update
//            this.personService.updatePerson(p);
//        }
Person person=new Person();
        person.setName("Kumar");
        person.setCountry("America");
        this.personService.addPerson(person);
//       person.setId(1);
//        person.setName("Ratnesh Varma");
//        person.setCountry("India");
//
//        this.personService.updatePerson(person);
//        this.personService.removePerson(2);
        return "redirect:/per/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){

        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person/person";
    }

}