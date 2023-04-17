package com.app.Controller;
import com.app.Model.Buyer;
import com.app.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BuyerController {
    BuyerService buyerService;

    @Autowired
    public BuyerController (BuyerService buyerService){
        this.buyerService = buyerService;
    }
    @PostMapping("buyer")
    public Buyer addAccount(@RequestBody Buyer account){
        return buyerService.addAccount(account);
    }
    @GetMapping("buyer")
    public List<Buyer> getAllAccounts(){
        return buyerService.getAllBuyers();
    }

}