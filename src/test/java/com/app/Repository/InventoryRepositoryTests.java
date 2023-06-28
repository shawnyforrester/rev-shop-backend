package com.app.Repository;

import com.app.Model.Product;
import com.app.Model.Retailer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class InventoryRepositoryTests {

    @Autowired
    private InventoryRepository inventoryRepository;




    @Test
    public void InventoryRepository_saveInventory_ReturnedSavedInventory(){

        //arrange

        Product product = Product.builder()
                .id(1)
                .price("$100")
                .category("Shirt")
                //.retailer()
                .description("A t-shirt")
                .build();

        //act
        Product savedProduct = inventoryRepository.save(product);
        //assert
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getPrice()).isNotBlank();
    }


}
