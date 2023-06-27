/*
package com.app.Controller;

import com.app.Response.PaymentResponse;
import com.app.Service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final StripeService stripeService;

    @Autowired
    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/charge")
    public ResponseEntity<PaymentResponse> createCharge(@RequestBody Map<String, Object> requestMap) {
        try {
            String token = (String) requestMap.get("token");
            int amount = (int) requestMap.get("amount");
            stripeService.createCharge(token, amount);
            PaymentResponse response = new PaymentResponse("Payment has been successful!");
            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            PaymentResponse response = new PaymentResponse("Payment failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

*/
