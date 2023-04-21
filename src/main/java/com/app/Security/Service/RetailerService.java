package com.app.Security.Service;

import com.app.Model.Retailer;
import com.app.Model.User;
import com.app.Repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailerService {
    RetailerRepository retailerRepository;

    @Autowired
    public RetailerService(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    public List<Retailer> getAllRetailers(){
        return retailerRepository.findAll();
    }

    public Retailer addAccount(User user) {
        Retailer newRetailer = new Retailer (user.getName(), user.getUsername(), user.getPassword());
        return retailerRepository.save(newRetailer);
    }
    public Retailer getRetailerByUsername(String username){return retailerRepository.getRetailerByUsername(username);}
}
