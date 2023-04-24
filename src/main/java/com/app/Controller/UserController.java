package com.app.Controller;


import com.app.Exception.UserNotFound;
import com.app.Model.Buyer;
import com.app.Service.AdministratorService;
import com.app.Service.BuyerService;
import com.app.Service.RetailerService;
import com.app.Service.userService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.Model.User;

import java.io.UnsupportedEncodingException;

/**
 * I have implemented a single controller to handle login, registration, and logout of any user type
 * This controller then uses instances of the admin, buyer, and retailer services to persist each user type in their respective repos.
 */
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true",
        maxAge = 3600)
@RestController
@RequestMapping
public class UserController {


    userService us;

    AdministratorService adminService;

    RetailerService retailerService;

    BuyerService buyerService;
    //MessageResponse messageResponse;

    public UserController(com.app.Service.userService us, com.app.Service.AdministratorService adminService,
                          RetailerService retailerService, BuyerService buyerService) {
        this.us = us;
        this.adminService = adminService;
        this.retailerService = retailerService;
        this.buyerService = buyerService;

    }


    /**
     * I have attempted to add additional code using authentication manager and jwtUtils to authenticate and create a secure Cookie
     * for login for each user
     */
    @PostMapping("login")
    public Buyer login(@RequestBody Buyer buyer) {
        try {
            Buyer buyerLogin = buyerService.login(buyer.getUsername(), buyer.getPassword());
            return buyerLogin;
        } catch (UserNotFound e) {
            System.out.println("invalid login credentials");
            return null;
        }
    }


    /**
     * This endpoint handles new "user" registration. Each user is assigned to a datatable based on the value in the
     * "role" parameter. The user is also added to a general datatable called "users"
     */
    @PostMapping("registration")
    public Buyer addAccount(@RequestBody Buyer buyer) throws MessagingException, UnsupportedEncodingException {
        return us.addAccount(buyer);
    }


    @PostMapping("logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, "NewCookie")
                .body("You've been signed out!");
    }


}
