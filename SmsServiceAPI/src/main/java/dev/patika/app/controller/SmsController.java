package dev.patika.app.controller;

import dev.patika.app.model.Sms;
import dev.patika.app.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @GetMapping
    public List<Sms> getAllSms(){
        return this.smsService.gellAll();
    }

    @PostMapping
    public Sms sendSms(@RequestParam String phone, @RequestParam String message){
        return this.prepareSms(phone, message);
    }

    public Sms prepareSms(String phone, String message){
        Sms sms = new Sms();
        sms.setPhone(phone);
        sms.setMessage(message);
        sms.setTimestamp(System.currentTimeMillis());
        return sms;
    }
}
