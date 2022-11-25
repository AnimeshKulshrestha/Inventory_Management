package com.ISDL.Inventory_management.locations;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Inventory_Repository extends JpaRepository<Inventory_Model,String> {

    @Query(value = "SELECT s FROM Inventory_Model s WHERE s.location = ?1")
    Optional<Inventory_Model> findInventoryByName(String location);
}
