package com.breadbites.controller;


import com.breadbites.entities.Registration;
import com.breadbites.global.GlobalFunctions;
import com.breadbites.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private GlobalFunctions globalFunctions;
    public ModelAndView modelAndView  = new ModelAndView();

    @RequestMapping("/registerPage")
    public ModelAndView SignUpPage(){

        modelAndView.setViewName("SignUp.html");
        return modelAndView;
    }


@PostMapping(value = "/register")
    public ModelAndView addNewUser(HttpServletRequest httpServletRequest){

    String name = httpServletRequest.getParameter("name");
    String email = httpServletRequest.getParameter("email");
    String password = httpServletRequest.getParameter("password");
    String confirmPassword = httpServletRequest.getParameter("confirm_password");

    System.out.println(name);
    System.out.println(email);
    System.out.println(password);
    System.out.println(confirmPassword);


      Optional<Registration> check = registrationService.checkExistence(email);
      if(check.isPresent()){
          System.out.println("User is already exist with this mail try with another one");
          return new ModelAndView("SignUp.html");
      }
      else {
          if(password.equals(confirmPassword)){
              registrationService.registerCustomer(name,email,password,confirmPassword);
              return new ModelAndView("index.html");
          }
          else{
              String message = "Password and Confirm Password does not match";
              System.out.println(message);
              return new ModelAndView("SignUp.html","errorMessage",message);
          }
}
}
//      @RequestMapping(value = "/loginPage")
//     public ModelAndView loginPage(){
//        return globalFunctions.loginPage();
//     }


}
