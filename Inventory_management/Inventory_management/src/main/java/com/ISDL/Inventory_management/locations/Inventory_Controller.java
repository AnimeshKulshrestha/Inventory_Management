package com.ISDL.Inventory_management.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inven_api/inventories")
@CrossOrigin
public class Inventory_Controller {

    private final Inventory_Service inventory_service;

    @Autowired
    public Inventory_Controller(Inventory_Service inventory_service) {
        this.inventory_service = inventory_service;
    }

    @GetMapping
    public List<Inventory_Model> getInventory(){
        return inventory_service.getInventory();
    }

    @PostMapping
    public void createInventory(@RequestBody Inventory_Model inventory_model){
        inventory_service.addInventory(inventory_model);
    }

    @DeleteMapping(path = "{inven_code}")
    public void deleteInventory(@PathVariable("inven_code") String code){
        inventory_service.deleteInventory(code);
    }

    @PutMapping(path = "{inven_code}")
    public void updateInventory(@PathVariable("inven_code") String code,
                                @RequestParam(required = false)String location){
        inventory_service.updateInventory(code,location);
    }

}
