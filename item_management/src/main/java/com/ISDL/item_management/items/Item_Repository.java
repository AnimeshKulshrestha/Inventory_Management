package com.ISDL.item_management.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface Item_Repository extends JpaRepository<Item,String> {

    @Query(value = "SELECT * FROM inventory s WHERE s.name=?1",
    nativeQuery = true)
    Collection<Item> findByName(String name);

    @Query(value = "SELECT * FROM inventory s WHERE s.location=?1",
            nativeQuery = true)
    Collection<Item> findByLocation(String location);

    @Query(value = "SELECT * FROM inventory s WHERE s.status=?1 AND s.location=?2",
            nativeQuery = true)
    Collection<Item> findByStatusAndLocation(String status,String location);
}
