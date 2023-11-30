package com.breadbites.global;

import com.breadbites.entities.Products;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Products> cart;

    static {
        cart = new ArrayList<Products>();
    }



}
