package com.app.Controller;

import com.app.Model.Administrator;
import com.app.Model.Retailer;
import com.app.Service.AdministratorService;
import com.app.Service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
@RestController
public class AdministratorController {
    AdministratorService administratorService;
    RetailerService retailerService;

    @Autowired
    AdministratorController (AdministratorService administratorService)  {
        this.administratorService = administratorService;
    }

    @GetMapping("administrator")
    public List<Administrator> getAllAccounts() throws Exception{
        return administratorService.getAllAccounts();
    }

    @GetMapping("administrator/{id}")
    public Administrator viewComplaintsByUser (@PathVariable Long id) {
        return this.administratorService.viewComplaintByUser(id);
    }

    @GetMapping("administrator/{retailer_id}")
    public Administrator viewRegistrationByRetailers (@PathVariable Long retailer_id) {
        return this.administratorService.viewRegistrationByRetailers(retailer_id);
    }
}