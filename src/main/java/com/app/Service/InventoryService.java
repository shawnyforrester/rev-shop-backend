package com.app.Service;

import com.app.Repository.InventoryRepository;
import com.app.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.Model.Product;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    public InventoryService (InventoryRepository inventoryRepository) {this.inventoryRepository = inventoryRepository;}

    InventoryRepository inventoryRepository;
    public List<Product> getAllInventory() {
        return inventoryRepository.findAll();}

    public Product addNewInventory(Product product) {
        return inventoryRepository.save(product);}

    public Product deleteInventoryById() { return null;}

    public List<Product> getProductByType(String type){
        return inventoryRepository.findProductByType(type);
    }
}