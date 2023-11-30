package com.breadbites.controller;

import com.breadbites.entities.Products;
import com.breadbites.entities.ProductsService;
import com.breadbites.global.GlobalFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private GlobalFunctions globalFunctions;

    @RequestMapping(value = "/landingPage")
    public ModelAndView landingPage(){
       return globalFunctions.landingPage();
    }
    @RequestMapping(value = "/loginPage")
    public ModelAndView loginPage(){
        return globalFunctions.loginPage();
    }
    @RequestMapping(value = "/registrationPage")
    public ModelAndView signUp(){
        return globalFunctions.signUp();
    }
    @RequestMapping(value = "/cart")
    public ModelAndView cartPage(){
       return globalFunctions.cartPage();
    }



}
