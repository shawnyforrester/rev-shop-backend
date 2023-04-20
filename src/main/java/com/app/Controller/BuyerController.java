package com.app.Controller;
import com.app.Exception.InvalidCredentials;
import com.app.Model.Buyer;
import com.app.Service.BuyerService;
import jakarta.mail.MessagingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Buyer getAccount(@RequestBody Buyer account){ return buyerService.getBuyerByUsername(account.getUsername());}
    @GetMapping("buyer")
    public List<Buyer> getAllAccounts(){
        return buyerService.getAllBuyers();
    }

}