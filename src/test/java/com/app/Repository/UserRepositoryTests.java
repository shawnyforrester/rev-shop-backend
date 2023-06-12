package com.app.Repository;
import com.app.Model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void UserRepository_saveUser_ReturnSavedUser() {
        //arrange - sets up the objects that will be tested with

        User user = User.builder()
                .id(1)
                .name("MyName")
                .username("NewUser")
                .email("someemail@gmail.com")
                .password("password1")
                .telephone("1231231234")
                .address("1234 Road St Texas")
                .role("user")
                .build();
        //act - the action or method that is being tested, saving a user
        User savedUser = userRepository.save(user);
        //assert - different tests and their results
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getPassword()).isNotBlank().isNotEmpty();

    }
}
