package com.ISDL.Inventory_management.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Inventory_Service {

    private final Inventory_Repository inventory_repository;

    @Autowired
    public Inventory_Service(Inventory_Repository inventory_repository) {
        this.inventory_repository = inventory_repository;
    }

    public List<Inventory_Model> getInventory() {
        return inventory_repository.findAll();
    }


    public void addInventory(Inventory_Model inventory_model) {
        Optional<Inventory_Model> inventory_byName = inventory_repository.findInventoryByName(inventory_model.getName());
        if(inventory_byName.isPresent()) {
            throw new IllegalStateException("email_taken");
        }
        inventory_repository.save(inventory_model);
    }

    public void deleteInventory(String code) {
        if(inventory_repository.existsById(code))
            inventory_repository.deleteById(code);
        else
            throw new IllegalStateException("inventory "+code+" doesn't exist");
    }

    @Transactional
    public void updateInventory(String code, String location) {
        Inventory_Model inventoryModel = inventory_repository.findById(code)
                .orElseThrow(() -> new IllegalStateException("Inventory "+code+" doesn't exist"));

        if(location!=null && location.length()>0 && !Objects.equals(inventoryModel.getName(),location)){
            Optional<Inventory_Model> inventory = inventory_repository.findInventoryByName(location);
            if(inventory.isPresent()){
                throw new IllegalStateException("Name already taken");
            }
            inventoryModel.setName(location);
        }

    }
}

