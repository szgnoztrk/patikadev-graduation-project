package dev.patika.customerservice.service;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.repository.CustomerRepository;
import dev.patika.customerservice.utility.mappers.CustomerMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerService service;

    @AfterEach
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    void getAll() {
        Customer customer = new Customer();
        customer.setSsid("29776973134");
        when(repository.findAll()).thenReturn(Collections.singletonList(customer));

        List<Customer> expected = service.getAll();

        assertEquals(expected.get(0).getSsid(), "29776973134");
    }

    @Test
    void save() {
        Customer expected = new Customer();
        expected.setSsid("29776973134");
        when(this.repository.existsAllBySsid(any())).thenReturn(Boolean.TRUE);
        when(this.repository.save(any())).thenReturn(expected);

        CustomerDTO customer = new CustomerDTO();
        Customer actual =this.service.save(customer).get();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getSsid(), actual.getSsid())
        );
    }
}