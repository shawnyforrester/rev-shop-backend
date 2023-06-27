package com.app.Service;

import com.app.Model.User;
import com.app.Repository.UserRepository;

import lombok.SneakyThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @SneakyThrows
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


        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User savedUser = userService.addAccount(user);

        Assertions.assertThat(savedUser).isNotNull();
    }

    @Test
    public void UserService_GetAllUsers_ReturnsAllUsers() {
        Page<User> userList = Mockito.mock(Page.class);

        when(userRepository.findAll(Mockito.any(Pageable.class))).thenReturn(userList);

        //TODO finish this section
    }



}
