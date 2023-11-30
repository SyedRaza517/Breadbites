package com.breadbites.controller;

import com.breadbites.entities.Products;
import com.breadbites.entities.ProductsService;
import com.breadbites.entities.Registration;
import com.breadbites.global.GlobalData;
import com.breadbites.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {


    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProductsService productsService;


    @PostMapping("/validateLogin")
    public ModelAndView validateLogin(HttpServletRequest httpServletRequest){



        String username = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");

        System.out.println("Name of user = "+username);
        System.out.println("Password of user = "+password);

        Optional<Registration> check = Optional.ofNullable(loginService.validates(username, password));

        System.out.println("Helllooo GGGGGG");
        System.out.println(check);

        System.out.println(check.isEmpty());

        if(check.isEmpty()){
            System.out.println("Its Empty");
            String message = "username and password does not exist";
            return new ModelAndView("index.html","errorMessage",message);
        }
        else {
            GlobalData.cart.clear();
//            System.out.println("Signing into Records Table");
//
//            List<Products> list = productsService.getAllProducts();
//            System.out.println(list);

            return new ModelAndView("Home.html");
        }
   }

}
