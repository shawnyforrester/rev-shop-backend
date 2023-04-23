package com.app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

/** I have included a field called quantity in this model and as such inventory may not be needed.
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String type;
    @Column
    private String size;
    @Column
    private Long quantity;
    @Column
    private String review;
    @Column
    private Double price;
    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "retailer_id", referencedColumnName = "id")
    private Retailer retailer;

}
