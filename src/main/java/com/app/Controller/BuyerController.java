
package com.app.Controller;

import com.app.Exception.InvalidCredentials;
import com.app.Exception.UserNotFound;
import com.app.Model.Buyer;
import com.app.Response.PaymentResponse;
import com.app.Service.BuyerService;
import jakarta.mail.MessagingException;
import org.apache.coyote.Response;
import com.app.Service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
@RestController
public class BuyerController {
    BuyerService buyerService;

    @Autowired
    public BuyerController (BuyerService buyerService){
        this.buyerService = buyerService;
    }
    @PostMapping("registration")
    public ResponseEntity<String> addAccount(@RequestBody Buyer buyer) throws MessagingException, UnsupportedEncodingException {
        buyerService.addAccount(buyer);
        return ResponseEntity.ok("Buyer Registered");
    }
    @PostMapping("login")
    public ResponseEntity<String>login(@RequestBody Buyer buyer){
        try{
            Buyer buyerLogin = buyerService.login(buyer.getUsername(), buyer.getPassword());
            return ResponseEntity.ok("Buyer Logged In");
        }
        catch(UserNotFound e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Login Credentials");
        }


    }
    @GetMapping("buyer")
    public List<Buyer> getAllAccounts(){
        return buyerService.getAllBuyers();
    }

}