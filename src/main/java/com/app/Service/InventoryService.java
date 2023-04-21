package com.app.Service;

import com.app.Model.Inventory;
import com.app.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {this.inventoryRepository = inventoryRepository;}

    public Inventory createInventory(Inventory inventory) {return inventoryRepository.save(inventory);}

    //TODO add increment or decrement to existing items quantity
}
