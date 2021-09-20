package dev.patika.app.service;

import dev.patika.app.model.Customer;
import dev.patika.app.model.CustomerDTO;
import dev.patika.app.repository.CustomerRepository;
import dev.patika.app.utility.exceptions.CustomerIsAlreadyExistsException;
import dev.patika.app.utility.exceptions.NotFoundCustomerException;
import dev.patika.app.utility.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<Customer> getAll(){ return this.repository.findAll(); }

    public Optional<Customer> getById(long id){
        if(this.repository.existsAllById(id))
            return Optional.of(this.repository.findAllById(id));
        else
            throw new NotFoundCustomerException("Customer with ID(" + id + ") not found!");
    }

    public Optional<Customer> getBySsid(String ssid){
        if(this.repository.existsAllBySsid(ssid))
            return Optional.of(this.repository.findAllBySsid(ssid));
        else
            throw new NotFoundCustomerException("Customer with SSID(" + ssid + ") not found!");
    }

    public Optional<Customer> getByPhone(String phone){
        if(this.repository.existsAllByPhone(phone))
            return Optional.of(this.repository.findAllByPhone(phone));
        else
            throw new NotFoundCustomerException("Customer with Phone(" + phone + ") not found!");
    }

    public Optional<Customer> getByEmail(String email){
        if(this.repository.existsAllByEmail(email))
            return Optional.of(this.repository.findAllByEmail(email));
        else
            throw new NotFoundCustomerException("Customer with E-mail(" + email + ") not found!");
    }

    public Optional<Customer> save(CustomerDTO customerDTO){
        if(this.repository.existsAllBySsid(customerDTO.getSsid()))
            throw new CustomerIsAlreadyExistsException("Customer with SSID(" + customerDTO.getSsid() + ") is already exists!");

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

    public void deleteBySsid(String ssid){
        Customer customer = this.getBySsid(ssid).get();
        this.repository.delete(customer);
    }

    public Optional<Customer> updateById(long id,CustomerDTO customerDTO){
        if(this.repository.existsAllById(id)){
            Customer customer = this.mapper.mapFromCustomerDTOToCustomer(customerDTO);
            return Optional.of(this.repository.save(customer));
        }
        else
            throw new NotFoundCustomerException("Customer with ID(" + id + ") not found!");
    }
}
