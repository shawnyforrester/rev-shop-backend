package com.app.Service;

import com.app.Exception.InvalidCredentials;
import com.app.Exception.UserNotFound;
import com.app.Model.Buyer;
import com.app.Model.User;
import com.app.Repository.BuyerRepository;
import com.app.Repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.Random;

@Service
public class userService {


    private UserRepository userRepo;

    private BuyerRepository buyerRepository;

    private EmailSenderService emailSenderService;

    private BuyerService buyerService;

    public userService (UserRepository userRepo, BuyerRepository buyerRepository,
                        EmailSenderService emailSenderService){

        this.userRepo = userRepo;

        this.buyerRepository = buyerRepository;

        this.emailSenderService = emailSenderService;
    }




    public Optional<User> getUserByUsername(String username) {
        Optional<User> newUser = userRepo.findByUsername(username);
        if (newUser.isPresent()) {
            return newUser;
        }
    return null;
    }



    public void addAccount(User user) throws MessagingException, UnsupportedEncodingException {
        userRepo.save(user);
    }

    public User login(String username, String password){
     User loggedUser = userRepo.findByUsernameAndPassword(username,password);

     if(loggedUser == null){
     throw new UserNotFound("Buyer Not Found");
     }

     return loggedUser;
     }

    public User changePassword(User user, long id){
        User newPass = userRepo.findById(id);
        newPass.setPassword(user.getPassword());
        System.out.println(newPass);
        userRepo.save(newPass);
        return newPass;
    }

}
