package com.breadbites.repositories;


import com.breadbites.entities.CheckoutDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutDetails, Long> {

}
