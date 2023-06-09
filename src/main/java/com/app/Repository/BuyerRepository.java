package com.app.Repository;
import com.app.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    Buyer findByEmail(String Email);
    Buyer findByUsernameAndPassword(String username, String password);

    Buyer findById(long id);

}
