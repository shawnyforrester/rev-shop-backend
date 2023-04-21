/**package com.app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long quantity;
    /**
     * Following should be fetching the id column from product table
     //TODO check functionality

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="product_id")


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="retailer_id")

}*/
