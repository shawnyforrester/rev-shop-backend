package com.app.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    private String telephone;

    private String address;

    private String role;



    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Product> products;

    public Retailer() {

    }

    public Retailer(String name, String username, String email, String password, String telephone, String address, String role) {
    }
}
