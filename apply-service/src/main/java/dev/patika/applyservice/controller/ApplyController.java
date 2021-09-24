package dev.patika.applyservice.controller;

import dev.patika.feignclient.client.CustomerServiceClient;
import dev.patika.feignclient.model.Customer;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit-apply")
public class ApplyController {
    @Autowired
    private CustomerServiceClient customerServiceClient;

    @GetMapping
    public ResponseEntity save(@RequestParam String ssid) {
        /* TODO - Check customer with SSID */
        try {
            ResponseEntity<Customer> responseCustomer = this.customerServiceClient.getCustomerBySsid(ssid);
            System.out.println(responseCustomer.getBody());
            return new ResponseEntity("ok", HttpStatus.OK);
        }catch (FeignException ex){
            return new ResponseEntity("Customer with SSID not found!", HttpStatus.BAD_REQUEST);
        }

        /* TODO - Check credit score */
        /* TODO - Send result sms */
        /* TODO - Log for database result sms */

    }
}
