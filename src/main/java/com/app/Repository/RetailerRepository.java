package com.app.Repository;

import com.app.Model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RetailerRepository extends JpaRepository<Retailer,Long> {

    @Query("FROM Retailer WHERE username = :username")
    Retailer getRetailerByUsername(@Param("username")String username);
}