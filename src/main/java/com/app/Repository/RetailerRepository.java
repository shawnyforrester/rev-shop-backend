package com.app.Repository;

import com.app.Model.Buyer;
import com.app.Model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer,Long> {
}