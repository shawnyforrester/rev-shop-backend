package com.app.Service;
import com.app.Exception.InvalidCredentials;
import com.app.Exception.UserNotFound;
import com.app.Model.Buyer;
import com.app.Model.User;
import com.app.Repository.BuyerRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

@Service
public class BuyerService {

    BuyerRepository buyerRepository;
    EmailSenderService emailSenderService;

    UserService us;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository, EmailSenderService emailSenderService,
                        UserService us) {
        this.buyerRepository = buyerRepository;
        this.emailSenderService = emailSenderService;
        this.us = us;

    }

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }


//    public Buyer addAccount(User user){
//        Buyer newBuyer = new Buyer (user.getUsername(), user.getPassword());
//        buyerRepository.save(newBuyer);
//        return newBuyer;
//    }


    public Buyer getBuyerByUsername(User user){
        return buyerRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

   public void addBuyer(User user) throws MessagingException, UnsupportedEncodingException {

       Buyer existingBuyer = buyerRepository.findByEmail(user.getEmail());
       if (existingBuyer != null) {
           throw new InvalidCredentials("Email " + user.getEmail() + " already exists");
       }
       System.out.println((user.getEmail()));

       Random random = new Random();
       String tempPass = String.valueOf(random.nextInt(9999999));
       user.setPassword(tempPass);

       Buyer newBuyer = new Buyer(user.getName(), user.getUsername(), user.getEmail(),
               user.getPassword(), user.getTelephone(), user.getAddress(), user.getRole());

       emailSenderService.sendRegistrationEmail(user);
       buyerRepository.save(newBuyer);

   }


}
