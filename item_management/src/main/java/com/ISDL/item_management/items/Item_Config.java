package com.ISDL.item_management.items;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class Item_Config {

    @Bean
    CommandLineRunner commandLineRunneritem(Item_Repository repository)
    {
        return args -> {
            Item item = new Item("chair_lt_1","chair","academic","working");
            Item item2 = new Item("chair_lt_2","chair","academic","working");
            Item item3 = new Item("table_lt_1","table","academic","working");
            Item item4 = new Item("table_lib_1","table","library","working");
            ArrayList<Item> list = new ArrayList<Item>();
            list.add(item);
            list.add(item2);
            list.add(item3);
            list.add(item4);
            repository.saveAll(list);
        };
    }
}
