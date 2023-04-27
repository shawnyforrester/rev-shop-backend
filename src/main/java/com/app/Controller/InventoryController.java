package com.app.Controller;

import com.app.Service.InventoryService;
import com.app.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://ec2-35-84-46-133.us-west-2.compute.amazonaws.com", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}, allowCredentials = "true")
@RestController
public class InventoryController {
    InventoryService inventoryService;
    @Autowired
    public InventoryController (InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping ("inventory")
    public List<Product> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping("inventory")
    public Product addNewInventory(@RequestBody Product product){
        return inventoryService.addNewInventory(product);
    }

    @DeleteMapping("inventory/{title}")
    public Product deleteInventoryById(@PathVariable String title){
        return inventoryService.deleteInventoryByTitle(title);
    }

    @GetMapping ("inventory/{category}")
    public List<Product> getSpecificCategory(@PathVariable String category) {
        return inventoryService.getSpecificCategory(category);
    }

    @GetMapping("inventory/categories")
    public List<String> getAllCategories() {
        return inventoryService.getAllCategories();
    }



//    @GetMapping(value = "inventory", params = {"type"})
//    public List<Product> getProductByType(@RequestParam("type") String type){
//        return inventoryService.getProductByType(type);
    }



