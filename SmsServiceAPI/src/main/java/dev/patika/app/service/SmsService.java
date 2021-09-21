package dev.patika.app.service;

import dev.patika.app.model.Sms;
import dev.patika.app.repository.SmsRepository;
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
