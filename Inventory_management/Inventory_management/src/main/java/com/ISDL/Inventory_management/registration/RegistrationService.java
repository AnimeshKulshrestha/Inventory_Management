package com.ISDL.Inventory_management.registration;

import com.ISDL.Inventory_management.AppUser.AppUser;
import com.ISDL.Inventory_management.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;
    private AppUserService appUserService;


    public String register(RegistrationRequest request) {
        Boolean isEmailValid = emailValidator.test(request.getEmail());
        if(!isEmailValid){
            throw new IllegalStateException("Email is not valid");
        }
        return appUserService.signUpUser(
                new AppUser(request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getIsAdmin())
        );
    }
}
