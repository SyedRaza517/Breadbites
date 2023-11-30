package com.breadbites.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
public class CheckoutDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String postCode;
    private String town;
    private String phone;
    private String email;
    private String sortCode;
    private String accountNumber;
    private String additionalInformation;


    public CheckoutDetails(String firstName, String lastName, String address1, String address2,
                           String postCode, String town, String phone, String email, String sortCode,
                           String accountNumber, String additionalInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postCode = postCode;
        this.town = town;
        this.phone = phone;
        this.email = email;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.additionalInformation = additionalInformation;
    }
}
