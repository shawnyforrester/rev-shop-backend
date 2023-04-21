package com.app.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/buyer")
    @PreAuthorize("hasRole('BUYER') or hasRole('RETAILER') or hasRole('ADMIN')")
    public String buyerAccess() {
        return "Buyer Content.";
    }

    @GetMapping("/retailer")
    @PreAuthorize("hasRole('RETAILER')")
    public String retailerAccess() {
        return "Retailer Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }


}
