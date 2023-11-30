package com.breadbites.service;


import com.breadbites.entities.Registration;
import com.breadbites.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private RegistrationRepository registrationRepository;


    public Registration validates(String username , String password){

        System.out.println("Login Service");
        System.out.println(username);
        System.out.println(password);

        return registrationRepository.findByNameAndPassword(username,password);
    }



}
