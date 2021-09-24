package dev.patika.smsservice.model;

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
    private String ssid;
    private String phone;
    private String message;
    private int creditScore;
    private double salary;
    private double creditLimit;

    public Sms(String s) {
        this.ssid = s;
    }
}
