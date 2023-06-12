package com.app.Service;

import com.app.Model.User;
import com.app.Repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void UserService_CreateUser_ReturnsUser() {

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
        //TODO implement actions and assertions


    }
}
