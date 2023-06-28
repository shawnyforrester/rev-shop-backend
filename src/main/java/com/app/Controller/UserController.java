package com.app.Controller;


import com.app.Exception.UserNotFound;
import com.app.Model.User;
import com.app.Service.AdministratorService;
import com.app.Service.BuyerService;
import com.app.Service.RetailerService;
import com.app.Service.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * I have implemented a single controller to handle login, registration, and logout of any user type
 * This controller then uses instances of the admin, buyer, and retailer services to persist each user type in their respective repos.
 */
@CrossOrigin(origins = "http://ec2-35-84-46-133.us-west-2.compute.amazonaws.com", allowedHeaders = "*", allowCredentials = "true",
        maxAge = 3600)
@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AdministratorService adminService;
    private final RetailerService retailerService;
    private final BuyerService buyerService;

    /**
     * I have attempted to add additional code using authentication manager and jwtUtils to authenticate and create a secure Cookie
     * for login for each user
     */
    @GetMapping("login")
    public User login(@RequestBody User user) {
        try {
            return userService.login (user.getUsername(), user.getPassword());

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
    public ResponseEntity addAccount(@RequestBody User user) throws MessagingException, UnsupportedEncodingException {

        if(user.getRole().equals("buyer")
            && userService.getUserByUsername(user.getUsername()) == null){
            buyerService.addBuyer(user);
            userService.addAccount(user);
            return ResponseEntity.ok("Buyer successfully added");

        }else if (user.getRole().equals("retailer")){
            retailerService.addAccount(user);
            userService.addAccount(user);
            return ResponseEntity.ok("Retailer successfully added");
        }else{
            return ResponseEntity.badRequest().build();
        }


    }


    @PostMapping("logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, "NewCookie")
                .body("You've been signed out!");
    }

    @PatchMapping("login/{id}")
    public User changePassword(@RequestBody User user, @PathVariable int id){
        return userService.changePassword(user, id);
    }


}
