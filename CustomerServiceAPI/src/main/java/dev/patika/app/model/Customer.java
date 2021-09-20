package dev.patika.app.model;

import dev.patika.app.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String ssid;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
