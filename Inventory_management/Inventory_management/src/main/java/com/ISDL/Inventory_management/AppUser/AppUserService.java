package com.ISDL.Inventory_management.AppUser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AppUserService{

    private final static String USER_NOT_FOUND
            ="user with email %s not found";
    private final AppUser_Repository appUser_repository;

    public String signUpUser(AppUser appUser){
        if(appUser_repository.findByEmail(appUser.getEmail()).isPresent())
            throw new IllegalStateException("Email already taken");

        appUser_repository.save(appUser);
        return ";";
    }

    public Boolean getCurUser(String email){
        Optional<AppUser> curUser = appUser_repository.findByEmail(email);
        if(curUser.isPresent()){
            return curUser.get().getIsAdmin();
        }
        return false;
    }

    public Boolean checkLogin(String email,String pass){
        Optional<AppUser> loginUser = appUser_repository.findByEmailAndPassword(email,pass);
        if(loginUser.isPresent())
            return true;
        return false;
    }

}
