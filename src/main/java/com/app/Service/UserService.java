package com.app.Service;

import com.app.Exception.UserNotFound;
import com.app.Model.User;
import com.app.Repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepo;


    public Optional<User> getUserByUsername(String username) {
        Optional<User> newUser = userRepo.findByUsername(username);
        if (newUser.isPresent()) {
            return newUser;
        }
        return null;
    }



    public User addAccount(User user) throws MessagingException, UnsupportedEncodingException {
        try{
            userRepo.save(user);
        }
        catch(Exception e){
            throw new UnsupportedEncodingException();
        }
        return user;
    }

    public User login(String username, String password){
        User loggedUser = userRepo.findByUsernameAndPassword(username,password);

        if(loggedUser.getUsername() == null){
            throw new UserNotFound("Account Not Found");
        }
        if(loggedUser.getUsername().equals(username) && loggedUser.getPassword().equals(password)){
        return loggedUser;
        }else{
            return null;
        }
    }

    public User changePassword(User user, int id){
        User newPass = userRepo.findById(id).get();
        newPass.setPassword(user.getPassword());
        System.out.println(newPass);
        userRepo.save(newPass);
        return newPass;
    }

}
