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


//    public User addUser(User user) throws MessagingException, UnsupportedEncodingException {
//        if(user.getRole() == "buyer"){
//            Buyer existingBuyer = buyerRepository.findByEmail(user.getEmail());
//            if(existingBuyer !=null){
//                throw new InvalidCredentials("Email " + user.getEmail() + " already exists");
//            }
//            System.out.println((user.getEmail()));
//
//            Random random = new Random();
//            String tempPass = String.valueOf(random.nextInt(9999999));
//            user.setPassword(tempPass);
//
//            buyerService.addAccount(user);
//
//            emailSenderService.sendRegistrationEmail(user);
//        }
//        return userRepo.save(user);
//
//    }

    public void addAccount(User user) throws MessagingException, UnsupportedEncodingException {

//        User existingUser = userRepo.findByEmail(user.getEmail()).get();
//        if(existingUser !=null){
//            throw new InvalidCredentials("Email " + user.getEmail() + " already exists");
//        }
//        System.out.println((user.getEmail()));


//        Random random = new Random();
//        String tempPass = String.valueOf(random.nextInt(9999999));
//        user.setPassword(tempPass);
        userRepo.save(user);
        //emailSenderService.sendRegistrationEmail(user);

    }

    public User login(String username, String password){
     User loggedUser = userRepo.findByUsernameAndPassword(username,password);

     if(loggedUser == null){
     throw new UserNotFound("Buyer Not Found");
     }

     return loggedUser;
     }

}
