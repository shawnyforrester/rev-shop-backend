package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    private String name;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String number;
    @Column
    private String address;

    @Column
    private String role;
}
