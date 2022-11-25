package com.ISDL.item_management.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class Item_Service {

    private final Item_Repository item_repository;

    @Autowired
    public Item_Service(Item_Repository item_repository) {
        this.item_repository = item_repository;
    }

    public List<Item> getItems(){
        return item_repository.findAll();
    }

    public List<Item> getByName(String name){
        if(name==null || name.length()==0)
            throw new IllegalStateException("No name input");
        List<Item> nameItems = (List<Item>) item_repository.findByName(name);
        return nameItems;
    }

    public void addItem(Item item){
        item_repository.save(item);
    }

    public void deleteItem(String code){
        if(item_repository.existsById(code))
            item_repository.deleteById(code);
        else
            throw new IllegalStateException("Item "+code+" doesn't exist");
    }

    public void updateItem(String id,String status){
            Item item = item_repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Item "+id+" does not exist "+status));
            Item newitem = new Item(item.getId(), item.getName(), item.getLocation(), status);
            item_repository.delete(item);
            item_repository.save(newitem);
            System.out.println(item.toString());

    }

    public List<Item> getByState(String status,String location) {
        if(status==null || status.length()==0)
            throw new IllegalStateException("No status input");
        if(location==null || location.length()==0)
            throw new IllegalStateException("No location input");
        List<Item> statusItems = (List<Item>) item_repository.findByStatusAndLocation(status,location);
        return statusItems;
    }

    public List<Item> getBylocation(String location) {
        if(location==null || location.length()==0)
            throw new IllegalStateException("No name input");
        List<Item> locationItems = (List<Item>) item_repository.findByLocation(location);
        return locationItems;
    }
}

