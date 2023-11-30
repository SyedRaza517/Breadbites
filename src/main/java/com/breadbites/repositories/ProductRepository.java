package com.breadbites.repositories;

import com.breadbites.entities.Products;
import com.breadbites.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

   Products findByName(String name);
}
