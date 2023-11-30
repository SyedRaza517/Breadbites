package com.breadbites.controller;


import com.breadbites.entities.Products;
import com.breadbites.entities.ProductsService;
import com.breadbites.global.GlobalData;
import com.breadbites.global.GlobalFunctions;
import com.breadbites.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CartController {


    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartService cartService;
    @Autowired
    private GlobalFunctions globalFunctions;


    @GetMapping(value = "/addToCart/{id}")
    public ModelAndView addToCart(@PathVariable Long id){

        GlobalData.cart.add(productsService.getProductbyId(id).get());

        List<Products> list = productsService.getAllProducts();
        System.out.println(list);
        System.out.println(GlobalData.cart);

        return new ModelAndView("shop.html","products",list);

    }


    @GetMapping(value = "/cart")
    public ModelAndView cartGet(Model model){

        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToInt(Products::getPrice).sum());

        return new ModelAndView("cart.html","cart",GlobalData.cart);

    }

    @GetMapping(value = "/cart/removeItem/{index}")
        public ModelAndView removeItem(@PathVariable int index,Model model){

        System.out.println("Index of this is = "+index);
        GlobalData.cart.remove(index);
        System.out.println("One item is removed from the cart");
       // GlobalData.cart.clear();

        System.out.println(GlobalData.cart.size());
        System.out.println(GlobalData.cart);

        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToInt(Products::getPrice).sum());


        return new ModelAndView("cart.html","cart",GlobalData.cart);
    }

    @RequestMapping(value = "/checkout")
    public ModelAndView checkOut(Model model){
       Integer total = GlobalData.cart.stream().mapToInt(Products::getPrice).sum();
        System.out.println("Total"+total);
        int afterDiscount = 0;
       if(total >= 50 )
       {
           System.out.println("In if Condition");
           int discount = total / 5;
           System.out.println("Discount"+discount);
           afterDiscount = total - discount;
       }
        System.out.println("IN checkout page");
       model.addAttribute("afterDiscount",afterDiscount);
       return new ModelAndView("checkout.html","total",total);

    }

    @RequestMapping(value = "/cart/landingPage")
    public ModelAndView landingPage(){
        return globalFunctions.landingPage();
    }
    @RequestMapping(value = "/cart/loginPage")
    public ModelAndView loginPage(){
        return globalFunctions.loginPage();
    }
    @RequestMapping(value = "/cart/registrationPage")
    public ModelAndView signUp(){
        return globalFunctions.signUp();
    }
    @RequestMapping(value = "/cart/home")
    public ModelAndView home(){
        return globalFunctions.homePage();
    }






}
