package com.ISDL.Inventory_management.locations;

import javax.persistence.*;

@Entity
@Table(
        //location = "Locations",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_location_constrains",columnNames = "Location")
        }
)
public class Inventory_Model {

    @Id
    @Column(
            name = "UID",
            updatable = false
    )
    private String code;
    @Column(
            name = "Location",
            nullable = false
    )
    private String location;

    public Inventory_Model(String code, String location) {
        this.code = code;
        this.location = location;
    }

    public Inventory_Model() {
    }

    public Inventory_Model(String name) {
        this.location = name;
    }

    @Override
    public String toString() {
        return "Inventory_Model{" +
                "code='" + code + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return location;
    }

    public void setName(String name) {
        this.location = name;
    }
}
