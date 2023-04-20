package com.app.Repository;
import com.app.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    Buyer findByEmail(String email);
    @Query("FROM Buyer WHERE username = :username")
    Buyer getUserByUsername(@Param("username")String username);

}
