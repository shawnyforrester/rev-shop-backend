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
    private long quantity;
    @Column
    private String review;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "retailer_id", referencedColumnName = "id")
    private Retailer retailer;

}
