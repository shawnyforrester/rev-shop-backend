package com.app.Service;

import com.app.Exception.InvalidCredentials;
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

    public Buyer addAccount(Buyer buyer) throws MessagingException, UnsupportedEncodingException {

        Buyer existingBuyer = buyerRepository.findByEmail(buyer.getEmail());
        if(existingBuyer !=null){
            throw new InvalidCredentials("Email " + buyer.getEmail() + " already exists");
        }
        System.out.println((buyer.getEmail()));

        Random random = new Random();
        String tempPass = String.valueOf(random.nextInt(9999999));
        buyer.setPassword(tempPass);
        emailSenderService.sendRegistrationEmail(buyer);
        return buyerRepository.save(buyer);


    }

}
