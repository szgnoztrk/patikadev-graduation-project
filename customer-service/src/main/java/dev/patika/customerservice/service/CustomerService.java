package dev.patika.customerservice.service;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.repository.CustomerRepository;
import dev.patika.customerservice.utility.exceptions.CustomerIsAlreadyExistsException;
import dev.patika.customerservice.utility.exceptions.NotFoundCustomerException;
import dev.patika.customerservice.utility.exceptions.SsidWrongFormatException;
import dev.patika.customerservice.utility.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<Customer> getAll(){ return this.repository.findAll(); }

    public Optional<Customer> getById(long id){
        if(this.repository.existsAllById(id)) {
            log.info("Customer with ID(" + id + ") found!");
            return Optional.of(this.repository.findAllById(id));
        }
        else {
            log.warn("Customer with ID(" + id + ") not found!");
            throw new NotFoundCustomerException("Customer with ID(" + id + ") not found!");
        }
    }

    public Optional<Customer> getBySsid(String ssid){
        if(this.repository.existsAllBySsid(ssid)) {
            log.info("Customer with SSID(" + ssid + ") found!");
            return Optional.of(this.repository.findAllBySsid(ssid));
        }
        else if(ssid.charAt(ssid.length() - 1) % 2 == 1) {
            log.warn("SSID: The last digit cannot be an odd number.");
            throw new NotFoundCustomerException("SSID: The last digit cannot be an odd number.");
        }
        else {
            log.warn("Customer with SSID(" + ssid + ") not found!");
            throw new NotFoundCustomerException("Customer with SSID(" + ssid + ") not found!");
        }
    }

    public Optional<Customer> getByPhone(String phone){
        if(this.repository.existsAllByPhone(phone))
            return Optional.of(this.repository.findAllByPhone(phone));
        else
            throw new NotFoundCustomerException("Customer with Phone(" + phone + ") not found!");
    }

    public Optional<Customer> save(CustomerDTO customerDTO){
        if(this.repository.existsAllBySsid(customerDTO.getSsid()))
            throw new CustomerIsAlreadyExistsException("Customer with SSID(" + customerDTO.getSsid() + ") is already exists!");

        if(customerDTO.getSsid().charAt(customerDTO.getSsid().length() - 1) % 2 == 1)
            throw new SsidWrongFormatException("SSID: The last digit cannot be an odd number.");

        if(this.repository.existsAllByPhone(customerDTO.getPhone()))
            throw new CustomerIsAlreadyExistsException("Customer with Phone(" + customerDTO.getPhone() + ") is already exists!");

        if(this.repository.existsAllByEmail(customerDTO.getEmail()))
            throw new CustomerIsAlreadyExistsException("Customer with Email(" + customerDTO.getEmail() + ") is already exists!");

        Customer customer = this.mapper.mapFromCustomerDTOToCustomer(customerDTO);
        return Optional.of(this.repository.save(customer));
    }

    public void deleteById(long id){
        Customer customer = this.getById(id).get();
        this.repository.delete(customer);
    }

    public Optional<Customer> updateById(long id,CustomerDTO customerDTO){
        if(this.repository.existsAllById(id)){
            if(this.repository.existsAllBySsid(customerDTO.getSsid()))
                throw new CustomerIsAlreadyExistsException("Customer with SSID(" + customerDTO.getSsid() + ") is already exists!");

            if(this.repository.existsAllByPhone(customerDTO.getPhone()))
                throw new CustomerIsAlreadyExistsException("Customer with Phone(" + customerDTO.getPhone() + ") is already exists!");

            if(this.repository.existsAllByEmail(customerDTO.getEmail()))
                throw new CustomerIsAlreadyExistsException("Customer with Email(" + customerDTO.getEmail() + ") is already exists!");

            Customer customer = this.mapper.mapFromCustomerDTOToCustomer(customerDTO);
            return Optional.of(this.repository.save(customer));
        }
        else
            throw new NotFoundCustomerException("Customer with ID(" + id + ") not found!");
    }
}
