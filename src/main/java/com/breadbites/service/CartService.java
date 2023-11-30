package com.breadbites.service;

import com.breadbites.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;


    public void deleteById(Long id){

        productRepository.deleteById(id);

    }

}
