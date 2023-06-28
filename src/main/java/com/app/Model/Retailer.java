package com.app.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
Zack
    - switched written constructors, setters, and getters to use Spring annotations
    -And AllArgsConstructor was needed and added for Mockito and Junit testing of the repository.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String telephone;
    private String address;
    private String role;



    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Product> products;


    public Retailer(String name, String username, String email, String password, String telephone, String address, String role) {
    }
}
