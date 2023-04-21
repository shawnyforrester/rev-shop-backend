package com.app.Controller;


import com.app.Service.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.Model.User;

/**I have implemented a single controller to handle login, registration, and logout of any user type
 * This controller then uses instances of the admin, buyer, and retailer services to persist each user type in their respective repos.
 *
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

    public UserController(userService us, AdministratorService adminService,
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
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {

        if (us.getUserByUsername(user.getUsername()).isPresent()) {

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, "demoCookie")
                    .body(us.getUserByUsername(user.getUsername()));

        }
        return ResponseEntity.badRequest().body(null);

    }

    /**
     * This endpoint handles new "user" registration. Each user is assigned to a datatable based on the value in the
     * "role" parameter. The user is also added to a general datatable called "users"
     */
    @PostMapping("registration")
    public User registerUser(@RequestBody /*RegistrationRequest regRequest*/ User user) {

        /**This block assigns the user object to a specific datatable according to the role value */
        String role = user.getRole();
        switch (role) {
            case "admin":
                adminService.addAccount(user);
                break;
            case "retailer":
                retailerService.addAccount(user);
                break;
            default:
                buyerService.addAccount(user);
        }
        return us.addUser(user);


    }

    @PostMapping("logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, "NewCookie")
                .body("You've been signed out!");
    }


}
