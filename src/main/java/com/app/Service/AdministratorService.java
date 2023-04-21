package com.app.Service;

import com.app.Model.Administrator;
import com.app.Model.Buyer;
import com.app.Model.Retailer;
import com.app.Repository.AdministratorRepository;
import com.app.Repository.BuyerRepository;
import com.app.Repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdministratorService {
    AdministratorRepository administratorRepository;
    @Autowired
    AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAccounts() {
        List<Administrator> accountList = administratorRepository.findAll();
        return accountList;
    }

    public Administrator viewComplaintByUser(Long id){
        return null;
    }

    public Administrator viewRegistrationByRetailers(Long retailer_id){
        return null;
    }

    public Administrator addAccount(Administrator account){
        return administratorRepository.save(account);
    }

}
