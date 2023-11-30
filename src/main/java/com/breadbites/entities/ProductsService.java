package com.breadbites.entities;

import com.breadbites.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){

        return productRepository.findAll();

    }


    public Optional<Products> getProduct(Long id) {

        return productRepository.findById(id);
    }

    public Optional<Products> getProductbyId(Long id) {

        return productRepository.findById(id);
    }
}
