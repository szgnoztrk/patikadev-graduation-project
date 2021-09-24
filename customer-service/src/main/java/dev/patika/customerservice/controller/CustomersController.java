package dev.patika.customerservice.controller;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomersController {
    private final CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return this.service.getAll();
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId){
        return new ResponseEntity<>(this.service.getById(customerId).get(), HttpStatus.OK);
    }

    @GetMapping("/ssid/{customerSsid}")
    public ResponseEntity<Customer> getCustomerBySsid(@PathVariable String customerSsid){
        return new ResponseEntity<>(this.service.getBySsid(customerSsid).get(), HttpStatus.OK);
    }

    @GetMapping("/phone/{customerPhone}")
    public Customer getCustomerByPhone(@PathVariable String customerPhone){
        return this.service.getByPhone(customerPhone).get();
    }

    @PostMapping
    public Customer saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return this.service.save(customerDTO).get();
    }

    @PutMapping
    public Customer updateCustomer(@RequestParam long customerId, @Valid @RequestBody CustomerDTO customerDTO){
        return this.service.updateById(customerId, customerDTO).get();
    }

    @DeleteMapping
    public String deleteCustomer(@RequestParam long customerId){
        this.service.deleteById(customerId);
        return "Deleted customer with ID: " + customerId;
    }


}
