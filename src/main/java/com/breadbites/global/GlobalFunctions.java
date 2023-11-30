package com.breadbites.global;

import com.breadbites.entities.Products;
import com.breadbites.entities.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class GlobalFunctions {

    @Autowired
    private ProductsService productsService;

    Model model;
    private GlobalData globalData;

    public ModelAndView landingPage(){
        System.out.println("Signing into Records Table");

        List<Products> list = productsService.getAllProducts();
        System.out.println(list);
        return new ModelAndView("shop.html","products",list);
    }
    public ModelAndView loginPage(){
        System.out.println("Login Page");

        return new ModelAndView("index.html");
    }

    public ModelAndView signUp(){
        System.out.println("Registration Page");

        return new ModelAndView("SignUp.html");
    }

    public ModelAndView cartPage(){
        System.out.println("Cart Page");
        String total = String.valueOf(GlobalData.cart.stream().mapToInt(Products::getPrice).sum());
        model.addAttribute("total",total);
        return new ModelAndView("cart.html","cart",GlobalData.cart);
    }
    public ModelAndView homePage(){
        System.out.println("Cart Page");

        return new ModelAndView("Home.html");
    }


}
