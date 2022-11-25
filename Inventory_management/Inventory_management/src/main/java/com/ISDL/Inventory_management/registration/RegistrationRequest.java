package com.ISDL.Inventory_management.registration;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final Boolean isAdmin;
}
