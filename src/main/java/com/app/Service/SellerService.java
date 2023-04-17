package com.app.Service;
import com.app.Model.Seller;
import com.app.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    SellerRepository sellerRepository;
    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }
    public Seller addAccount(Seller account){
        return sellerRepository.save(account);
    }
}
