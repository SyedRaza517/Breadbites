package com.breadbites.controller;

import com.breadbites.global.GlobalFunctions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {

    @Autowired
    private GlobalFunctions globalFunctions;



    @PostMapping(value = "/payNow")
    public ModelAndView checkout(HttpServletRequest httpServletRequest){

        System.out.println("In Pay Now Method");
        String userName = httpServletRequest.getParameter("firstName");
        String userLastName = httpServletRequest.getParameter("lastName");
        String addressno1 = httpServletRequest.getParameter("address1");
        String addressno2 = httpServletRequest.getParameter("address2");
        System.out.println("FirstName"+userName);
        System.out.println("Last Name"+userLastName);
        System.out.println("Address 1"+addressno1);
        System.out.println("Address 2"+addressno2);

        return new ModelAndView("End.html");
    }


    @RequestMapping(value = "/checkout/loginPage")
    public ModelAndView loginPage(){
        System.out.println("Login Page");

        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/checkout/registration")
    public ModelAndView signUp(){
        return globalFunctions.signUp();
    }

    @RequestMapping(value = "/checkout/landingPage")
    public ModelAndView landingPage(){
        return globalFunctions.landingPage();
    }

    @RequestMapping(value = "/checkout/cart")
    public ModelAndView cartPage(){
        return globalFunctions.cartPage();
    }

    @RequestMapping(value = "/checkout/home")
    public ModelAndView home(){
        return new ModelAndView("Home.html");
    }

}
