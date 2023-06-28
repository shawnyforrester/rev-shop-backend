package com.app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String price;
    @Column(length=1530)
    private String description;
    private String category;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "retailer_id", referencedColumnName = "id")
    private Retailer retailer;

}
