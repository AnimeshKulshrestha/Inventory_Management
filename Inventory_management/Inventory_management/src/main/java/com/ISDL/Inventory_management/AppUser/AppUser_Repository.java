package com.ISDL.Inventory_management.AppUser;

import com.ISDL.Inventory_management.locations.Inventory_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUser_Repository extends JpaRepository<AppUser,String> {

    Optional<AppUser> findByEmail(String email);

    @Query(value = "SELECT * FROM app_user s WHERE s.email=?1 AND s.password=?2",
            nativeQuery = true)
    Optional<AppUser> findByEmailAndPassword(String email,String password);
}
