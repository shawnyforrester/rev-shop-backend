package com.app.Service;

import com.app.Model.User;
import com.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService {


    private UserRepository userRepo;

    public userService (UserRepository userRepo){
        this.userRepo = userRepo;
    }




    public Optional<User> getUserByUsername(String username) {
        Optional<User> newUser = userRepo.findByUsername(username);
        if (newUser.isPresent()) {
            return newUser;
        }
    return null;

    }


    public User addUser(User user){
        return userRepo.save(user);

    }

}
