package com.ratnesh.ems.controller;

import com.ratnesh.ems.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Created by ratnesh on 20/5/17.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public ModelAndView start(){

        return new ModelAndView("index","index",new Login());
    }

}
