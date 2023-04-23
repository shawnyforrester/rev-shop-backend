package com.app.Repository;


import com.app.Model.Buyer;
import com.app.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Product,Long> {
    @Query("FROM Product WHERE type = :type")
    List<Product> findProductByType(@Param("type") String type);
}
