package com.app.Controller;
import com.app.Model.Buyer;
import com.app.Response.PaymentResponse;
import com.app.Service.BuyerService;
import com.app.Service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Buyer addAccount(@RequestBody Buyer account){
        return buyerService.addAccount(account);
    }

    @PostMapping("login")
    public Buyer getAccount(@RequestBody Buyer account){ return buyerService.getBuyerByUsername(account.getUsername());}
    @GetMapping("buyer")
    public List<Buyer> getAllAccounts(){
        return buyerService.getAllBuyers();
    }

}