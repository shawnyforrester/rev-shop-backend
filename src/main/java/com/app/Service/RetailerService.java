package com.app.Service;

import com.app.Exception.InvalidCredentials;
import com.app.Model.Buyer;
import com.app.Model.Retailer;
import com.app.Model.User;
import com.app.Repository.RetailerRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

@Service
public class RetailerService {
    RetailerRepository retailerRepository;

    EmailSenderService emailSenderService;

    @Autowired
    public RetailerService(RetailerRepository retailerRepository,
                           EmailSenderService emailSenderService) {
        this.retailerRepository = retailerRepository;
        this.emailSenderService = emailSenderService;
    }

    public List<Retailer> getAllRetailers(){
        return retailerRepository.findAll();
    }

    public ResponseEntity addAccount(User user) throws MessagingException, UnsupportedEncodingException {

        Retailer existingRetailer = retailerRepository.getRetailerByUsername(user.getUsername());
        if (existingRetailer != null) {
            throw new InvalidCredentials("Email " + user.getEmail() + " already exists");
        }
        System.out.println((user.getEmail()));

        Random random = new Random();
        String tempPass = String.valueOf(random.nextInt(9999999));
        user.setPassword(tempPass);

        Retailer newRetailer = new Retailer (user.getName(), user.getUsername(), user.getEmail(),
                user.getPassword(), user.getTelephone(), user.getAddress(), user.getRole());


        emailSenderService.sendRegistrationEmail(user);

        return ResponseEntity.ok("Retailer added");
    }
    public Retailer getRetailerByUsername(String username){return retailerRepository.getRetailerByUsername(username);}
}

