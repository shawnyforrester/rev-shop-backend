package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;

}
