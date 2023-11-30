package com.breadbites.service;

import com.breadbites.entities.Products;
import com.breadbites.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ProductRepository productRepository;

    public Products getItems(String name) {

        return productRepository.findByName(name);
    }
}
