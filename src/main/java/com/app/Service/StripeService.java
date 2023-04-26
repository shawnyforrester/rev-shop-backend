package com.app.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public Charge createCharge(String token, int amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "Charge for Men's Clothing Store");
        chargeParams.put("source", token);
        return Charge.create(chargeParams);
    }
}