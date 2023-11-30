package com.breadbites.controller;

import com.breadbites.entities.Products;
import com.breadbites.entities.ProductsService;
import com.breadbites.global.GlobalData;
import com.breadbites.global.GlobalFunctions;
import com.breadbites.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ShopController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private GlobalFunctions globalFunctions;

    @GetMapping(value = "/shop/view_product/{id}")
    public ModelAndView viewProduct(@PathVariable Long id){

        Optional<Products> product = productsService.getProduct(id);
        System.out.println("In Print Method");
        System.out.println(product);

        return new ModelAndView("viewProduct.html","product",product.get());

    }

    @RequestMapping(value = "/shop/loginPage")
    public ModelAndView loginPage(){
        System.out.println("Login Page");

        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/shop/registration")
    public ModelAndView signUp(){
        return globalFunctions.signUp();
    }


    @RequestMapping(value = "/shop/cart")
    public ModelAndView cartPage(Model model){
        System.out.println("Cart Page");
        String total = String.valueOf(GlobalData.cart.stream().mapToInt(Products::getPrice).sum());
        model.addAttribute("total",total);
        return new ModelAndView("cart.html","cart",GlobalData.cart);
    }

    @RequestMapping(value = "/shop/home")
    public ModelAndView home(){
        return new ModelAndView("Home.html");
    }


    @GetMapping(value = "/searchItem")
    public ModelAndView searchItem(HttpServletRequest httpServletRequest){

        String name = httpServletRequest.getParameter("search");

        System.out.println("Search word"+name);

        Products searchedItems = shopService.getItems(name);
        System.out.println("Items got after search");
        System.out.println(searchedItems);

        return new ModelAndView("shop.html","products",searchedItems);


    }





}
