package com.app.Repository;


import com.app.Model.Buyer;
import com.app.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
