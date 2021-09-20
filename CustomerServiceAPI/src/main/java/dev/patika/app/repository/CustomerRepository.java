package dev.patika.app.repository;

import dev.patika.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsAllById(long id);
    boolean existsAllBySsid(String ssid);
    boolean existsAllByPhone(String phone);
    boolean existsAllByEmail(String email);

    Customer findAllById(long id);
    Customer findAllBySsid(String ssid);
    Customer findAllByPhone(String phone);
    Customer findAllByEmail(String email);
}
