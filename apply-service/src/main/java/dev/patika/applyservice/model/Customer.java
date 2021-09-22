package dev.patika.applyservice.model;

import dev.patika.applyservice.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long id;
    private String fullName;
    private String ssid;
    private String email;
    private String phone;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
