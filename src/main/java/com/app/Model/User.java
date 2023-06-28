package com.app.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Role;
import org.springframework.data.annotation.Id;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "users")

public class User {


    @jakarta.persistence.Id
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


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

