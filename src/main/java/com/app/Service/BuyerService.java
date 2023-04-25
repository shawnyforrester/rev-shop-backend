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

    @Autowired
    public BuyerService(BuyerRepository buyerRepository, EmailSenderService emailSenderService) {
        this.buyerRepository = buyerRepository;
        this.emailSenderService = emailSenderService;
    }

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }


    public Buyer addAccount(User user){
        Buyer newBuyer = new Buyer (user.getUsername(), user.getPassword());
        buyerRepository.save(newBuyer);
        return newBuyer;
    }


    public Buyer getBuyerByUsername(User user){
        return buyerRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

   /** public void addAccount(Buyer buyer) throws MessagingException, UnsupportedEncodingException {

       /** Buyer existingBuyer = buyerRepository.findByEmail(buyer.getEmail());
        if(existingBuyer !=null){
            throw new InvalidCredentials("Email " + buyer.getEmail() + " already exists");
        }
        System.out.println((buyer.getEmail()));

        Random random = new Random();
        String tempPass = String.valueOf(random.nextInt(9999999));
        buyer.setPassword(tempPass);

        buyerRepository.save(buyer);

        emailSenderService.sendRegistrationEmail(buyer);
    }*/

   public Buyer login(String username, String password){
       Buyer loginCredentials = buyerRepository.findByUsernameAndPassword(username,password);

       if(loginCredentials == null){
           throw new UserNotFound("Buyer Not Found");
       }

       loginCredentials.setUsername(username);
       loginCredentials.setPassword(password);


       return loginCredentials;
   }
}
