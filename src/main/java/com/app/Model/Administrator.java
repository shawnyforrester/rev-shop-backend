package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;

    public Administrator(String name, String username, String password) {

    }

    public Administrator() {

    }

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name=" ")
    //TODO add the foreign column name
    //private Long retailer_id;

}
