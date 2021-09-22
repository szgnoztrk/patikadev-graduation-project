package dev.patika.smsservice.service;

import dev.patika.smsservice.model.Sms;
import dev.patika.smsservice.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final SmsRepository repository;

    public Sms save(Sms sms){
        return this.repository.save(sms);
    }

    public List<Sms> gellAll(){
        return this.repository.findAll();
    }
}
