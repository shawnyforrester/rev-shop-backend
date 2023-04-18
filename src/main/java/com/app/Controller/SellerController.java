package com.app.Controller;
import com.app.Model.Seller;
import com.app.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class SellerController {
    SellerService sellerService;

    @Autowired
    public SellerController (SellerService sellerService){
        this.sellerService = sellerService;
    }
    @PostMapping("seller")
    public Seller addAccount(@RequestBody Seller account){
        return sellerService.addAccount(account);
    }
    @GetMapping("seller")
    public List<Seller> getAllAccounts(){
        return sellerService.getAllSellers();
    }
    @DeleteMapping("seller/{id}")
    public void deletesellerById(@PathVariable long id){
        sellerService.deleteAccountById(id);
    }

}