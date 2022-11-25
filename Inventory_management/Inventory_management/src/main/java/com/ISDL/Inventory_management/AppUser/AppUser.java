package com.ISDL.Inventory_management.AppUser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(
        name = "app_user"
)
public class AppUser{

    @Id
    @SequenceGenerator(
            name = "sequence_user",
            sequenceName = "sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_user"
    )
    private long id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private Boolean locked=false;
    private Boolean enabled=true;

    private Boolean isAdmin;

    public AppUser(String firstname, String lastname,String email, String password, Boolean isAdmin) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
