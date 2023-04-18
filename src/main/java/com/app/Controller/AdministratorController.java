package com.app.Controller;

import com.app.Model.Administrator;
import com.app.Model.Buyer;
import com.app.Service.AdministratorService;
import com.app.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = {"*"})
@RestController
public class AdministratorController {
    AdministratorService administratorService;
    BuyerService buyerService;

    @Autowired
    AdministratorController (AdministratorService administratorService)  {
        this.administratorService = administratorService;
    }

    @PostMapping("administrator")
    public Administrator addAccount(@RequestBody Administrator account){
        return administratorService.addAccount(account);
    }

    @GetMapping("administrator")
    public List<Administrator> getAllAccounts() throws Exception{
        return administratorService.getAllAccounts();
    }

    @PatchMapping("administrator")
    public Administrator updateBlockedAccount (@RequestBody Administrator administrator) {
        return this.administratorService.updateBlockedAccount(administrator);
    }

    @GetMapping("administrator/{id}")
    public Administrator viewComplaintsByUser (@PathVariable Long id) {
        return this.administratorService.viewComplaintByUser(id);
    }

    @GetMapping("administrator/{retailer_id}")
    public Administrator viewRegistrationByRetailers (@PathVariable Long id) {
        return this.administratorService.viewRegistrationByRetailers(id);
    }
}