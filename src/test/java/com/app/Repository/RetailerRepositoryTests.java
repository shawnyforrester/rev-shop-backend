package com.app.Repository;

import com.app.Model.Retailer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RetailerRepositoryTests {

    @Autowired
    private RetailerRepository retailerRepository;

    @Test
    public void RetailerRepository_SaveRetailer_ReturnSavedRetailer() {
        //arrange
        Retailer retailer = Retailer.builder()
                .id(1)
                .name("MyName")
                .username("NewUser")
                .email("someemail@gmail.com")
                .password("password1")
                .telephone("1231231234")
                .address("1234 Road St Texas")
                .role("user")
                .build();

        //act - the action or method that is being tested, saving a retailer
        Retailer savedRetailer = retailerRepository.save(retailer);

        //assert
        Assertions.assertThat(savedRetailer).isNotNull();
        Assertions.assertThat(savedRetailer.getId()).isGreaterThan(0);

    }

    @Test
    public void RetailerRepository_SaveMultipleRetailers_ReturnSavedRetailers() {
        //arrange
        Retailer retailer = Retailer.builder()
                .id(1)
                .name("MyName")
                .username("NewUser")
                .email("someemail@gmail.com")
                .password("password1")
                .telephone("1231231234")
                .address("1234 Road St Texas")
                .role("user")
                .build();

        Retailer retailer2 = Retailer.builder()
                .id(2)
                .name("SomeoneElse")
                .username("NewUser2")
                .email("anotheremail@gmail.com")
                .password("password2")
                .telephone("3212343456")
                .address("1234 Road St Chicago IL")
                .role("user")
                .build();



        //act
        Retailer savedRetailer = retailerRepository.save(retailer);
        Retailer savedRetailer2 = retailerRepository.save(retailer2);
        List<Retailer> retailerList = retailerRepository.findAll();


        //assert
        Assertions.assertThat(retailerList).isNotNull();
        Assertions.assertThat(retailerList.size()).isEqualTo(2);

    }
}
