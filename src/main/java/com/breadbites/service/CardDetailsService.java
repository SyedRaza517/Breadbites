package com.breadbites.service;

import com.breadbites.entities.CheckoutDetails;
import com.breadbites.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CardDetailsService {

    @Autowired
    private CheckoutRepository checkoutRepository;



    public void saveCardDetails(String firstName,
                                String lastName,
                                String address1,
                                String address2,
                                String postCode,
                                String town,
                                String phone,
                                String email,
                                String sortCode,
                                String accountNumber,
                                String additionalInformation){

        checkoutRepository.save(new CheckoutDetails(firstName,lastName,address1,address2,postCode,town,phone,email,sortCode,accountNumber,additionalInformation));
    }




}
