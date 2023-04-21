package com.app.Repository;

import com.app.Model.Buyer;
import com.app.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
