package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

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
    private String password;
    //@ManyToOne
    //@JoinColumn(name="inventory_id")
    //private Long inventory_id;
}
