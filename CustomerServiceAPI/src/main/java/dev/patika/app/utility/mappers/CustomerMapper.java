package dev.patika.app.utility.mappers;

import dev.patika.app.model.Customer;
import dev.patika.app.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer mapFromCustomerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO mapFromCustomerToCustomerDTO(Customer customer);
}
