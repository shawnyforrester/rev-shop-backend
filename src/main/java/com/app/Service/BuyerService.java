package com.app.Service;
import com.app.Model.Buyer;
import com.app.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    BuyerRepository buyerRepository;
    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }
    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }
    public Buyer addAccount(Buyer account){
        return buyerRepository.save(account);
    }
}
