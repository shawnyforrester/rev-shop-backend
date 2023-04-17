package com.app.Service;

import com.app.Model.Administrator;
import com.app.Model.Buyer;
import com.app.Repository.AdministratorRepository;
import com.app.Repository.BuyerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdministratorService {
    AdministratorRepository administratorRepository;
    BuyerRepository buyerRepository;
    @Autowired
    AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAccounts() {
        List<Administrator> accountList = administratorRepository.findAll();
        return accountList;
    }

    public Administrator updateBlockedAccount(Administrator administrator) {
        return null;
    }

    public Administrator viewComplaintByUser(Long id){
        Optional<Administrator> optionalComplaint = administratorRepository.findById(id);
        return optionalComplaint.get();
    }

    public Administrator viewRegistrationByRetailers(Administrator administrator){
        return null;
    }
}
