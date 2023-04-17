package com.app.Controller;

import com.app.Model.Administrator;
import com.app.Model.Buyer;
import com.app.Service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministratorController {
    AdministratorService administratorService;

    @Autowired
    AdministratorController (AdministratorService administratorService)  {
        this.administratorService = administratorService;
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

    @GetMapping("administrator/{id}")
    public Administrator viewRegistrationByRetailers (@RequestBody Administrator administrator) {
        return this.administratorService.viewRegistrationByRetailers(administrator);
    }
}