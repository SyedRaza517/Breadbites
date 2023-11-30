package com.breadbites.service;

import com.breadbites.entities.Registration;
import com.breadbites.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;


    public String registerCustomer(String name,String email,String password,String confirmPassword){

        registrationRepository.save(new Registration(name,email,password,confirmPassword));

        return "Customer has been registered";
    }


    public Optional<Registration> checkExistence(String email) {

       return registrationRepository.findByEmail(email);


    }
}
