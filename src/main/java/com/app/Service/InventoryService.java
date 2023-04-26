package com.app.Service;

import com.app.Repository.InventoryRepository;
import com.app.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    public InventoryService (InventoryRepository inventoryRepository) {this.inventoryRepository = inventoryRepository;}

    InventoryRepository inventoryRepository;
    public List<Product> getAllInventory() {
        return inventoryRepository.findAll();}

    public Product addNewInventory(Product product) {
        return inventoryRepository.save(product);}

    @Transactional
    public Product deleteInventoryByTitle(String title) {
        Optional<Product> optionalProduct = inventoryRepository.findByTitle(title);
        if (optionalProduct.isPresent()) {
            inventoryRepository.deleteByTitle(title);
            return optionalProduct.get();
        }
        return null;
    }

    public List<Product> getSpecificCategory(String category){
        return inventoryRepository.findByCategory(category);
    }

    public List<String> getAllCategories() {
        return inventoryRepository.findAllCategories();
    }

//    public List<Product> getProductByType(String type){
//        return inventoryRepository.findProductByType(type);
//    }
}
