//package com.app.Controller;
//
//import com.app.Model.Retailer;
//import com.app.Service.RetailerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
//@RestController
//public class RetailerController {
//
//    RetailerService retailerService;
//
//    @Autowired
//    public RetailerController(RetailerService retailerService) {
//        this.retailerService = retailerService;
//    }
//
//    @PostMapping("registration")
//    public Retailer addAccount(@RequestBody Retailer account) {
//        return retailerService.addAccount(account);
//    }
//
//    @PostMapping("login")
//    public Retailer getAccount(@RequestBody Retailer account) {
//        return retailerService.getRetailerByUsername(account.getUsername());
//    }
//}
