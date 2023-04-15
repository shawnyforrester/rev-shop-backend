package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String email;
    @Column
    private String telephone;
    @Column
    private String address;
}
