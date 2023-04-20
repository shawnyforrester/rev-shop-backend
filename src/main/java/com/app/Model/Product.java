package com.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String category;
    @Column
    private String type;
    @Column
    private String brand;
    @Column
    private String size;
    @Column
    private String review;

}
