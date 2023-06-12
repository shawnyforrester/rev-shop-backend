package com.app.Service;

import com.app.Exception.UserNotFound;
import com.app.Model.User;
import com.app.Repository.BuyerRepository;
import com.app.Repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepo;

    private BuyerRepository buyerRepository;

    private EmailSenderService emailSenderService;

    private BuyerService buyerService;

    public UserService (UserRepository userRepo, BuyerRepository buyerRepository,
                        EmailSenderService emailSenderService){

        this.userRepo = userRepo;


        this.emailSenderService = emailSenderService;
    }




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
