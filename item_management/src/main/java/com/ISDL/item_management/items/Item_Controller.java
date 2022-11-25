package com.ISDL.item_management.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inven_api/items")
@CrossOrigin
public class Item_Controller {
    private final Item_Service item_service;

    @Autowired
    public Item_Controller(Item_Service item_service) {
        this.item_service = item_service;
    }

    @GetMapping
    public List<Item> getItem(){
        return item_service.getItems();
    }

    @GetMapping(path = "location/{location}")
    public List<Item> getByLocation(@PathVariable("location") String location){
        return item_service.getBylocation(location);
    }

    @GetMapping(path = "{location}/{status}")
    public List<Item> getByStatus(@PathVariable("status") String status,
                                  @PathVariable("location") String location){
        return item_service.getByState(status,location);
    }

    @GetMapping(path = "name/{name}")
    public List<Item> getByName(@PathVariable("name") String name){
        return item_service.getByName(name);
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        item_service.addItem(item);
    }

    @DeleteMapping(path = "{item_code}")
    public void deleteItem(@PathVariable("item_code") String id){
        item_service.deleteItem(id);
    }

    @PutMapping(path = "{item_code}")
    public void updateItem(@PathVariable("item_code") String id,
                           @RequestParam(required = false)String status){
        item_service.updateItem(id,status);
    }
}
