package com.app.Service;
import com.app.Exception.InvalidCredentials;
import com.app.Model.Buyer;
import com.app.Repository.BuyerRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
//    public Buyer addAccount(Buyer account){
//        return buyerRepository.save(account);
//    }

    public Buyer getBuyerByUsername(String username){
        return buyerRepository.getUserByUsername(username);
    }

    public void addAccount(Buyer buyer) throws MessagingException, UnsupportedEncodingException {

        Buyer existingBuyer = buyerRepository.findByEmail(buyer.getEmail());
        if(existingBuyer !=null){
            throw new InvalidCredentials("Email " + buyer.getEmail() + " already exists");
        }
        System.out.println((buyer.getEmail()));

        buyerRepository.save(buyer);

        emailSenderService.sendRegistrationEmail(buyer);


    }
}
