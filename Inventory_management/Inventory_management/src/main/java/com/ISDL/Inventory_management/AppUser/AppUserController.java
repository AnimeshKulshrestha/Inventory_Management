package com.ISDL.Inventory_management.AppUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inven_api/user")
@AllArgsConstructor
@CrossOrigin
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping(path = "role/{email}")
    public Boolean isAdmin(@PathVariable("email") String email){
        return appUserService.getCurUser(email);
    }

    @PostMapping(path = "{email}/{password}")
    public Boolean login(@PathVariable("email") String email,
                         @PathVariable("password") String password){
        return appUserService.checkLogin(email,password);
    }
}
