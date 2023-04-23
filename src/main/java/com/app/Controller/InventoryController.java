package com.app.Controller;

import com.app.Service.InventoryService;
import com.app.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
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

    @DeleteMapping("inventory/{id}")
    public Product deleteInventoryById(@PathVariable Long id){
        return inventoryService.deleteInventoryById();
    }

    @GetMapping(value = "inventory", params = {"type"})
    public List<Product> getProductByType(@RequestParam("type") String type){
        return inventoryService.getProductByType(type);
    }


}
