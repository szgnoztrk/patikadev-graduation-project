package dev.patika.smsservice.service;

import dev.patika.smsservice.model.Sms;
import dev.patika.smsservice.repository.SmsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SmsServiceTest {
    @Mock
    SmsRepository repository;

    @InjectMocks
    SmsService smsService;

    @Test
    void save() {
        Sms expected = new Sms();
        expected.setSsid("29776973134");
        when(this.repository.save(any())).thenReturn(expected);

        Sms smsDto = new Sms();
        Sms actual =this.smsService.save(smsDto);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getSsid(), actual.getSsid())
        );

    }

    @Test
    void gellAll() {
        when(repository.findAll()).thenReturn(Collections.singletonList(
                new Sms("29776973134")
        ));

        List<Sms> expected = smsService.gellAll();

        assertEquals(expected.get(0).getSsid(), "29776973134");
    }
}