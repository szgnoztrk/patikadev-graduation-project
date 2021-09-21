package dev.patika.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sms_log")
public class Sms {
    @Id
    @GeneratedValue
    private long id;
    private Long timestamp;
    private String phone;
    private String message;
}
