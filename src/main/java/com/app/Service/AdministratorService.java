package com.app.Service;

import com.app.Model.Administrator;
import com.app.Model.User;
import com.app.Repository.AdministratorRepository;
import com.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdministratorService {
    AdministratorRepository administratorRepository;
    UserRepository userRepository;
    @Autowired
    AdministratorService(AdministratorRepository administratorRepository, UserRepository userRepository) {
        this.administratorRepository = administratorRepository;
        this.userRepository = userRepository;
    }

    public List<User> getAllAccounts() {
        List<User> accountList = userRepository.findAll();
        return accountList;
    }

    public Administrator viewComplaintByUser(Long id){
        return null;
    }

    public Administrator viewRegistrationByRetailers(Long retailer_id){
        return null;
    }

    public Administrator addAccount(User user){
        Administrator newAdmin = new Administrator (user.getName(), user.getUsername(), user.getPassword());
        return administratorRepository.save(newAdmin);
    }

}
