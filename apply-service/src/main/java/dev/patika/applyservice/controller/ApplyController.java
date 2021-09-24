package dev.patika.applyservice.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.applyservice.model.CreditLimitResult;
import dev.patika.feignclient.client.CustomerServiceClient;
import dev.patika.feignclient.client.ScoreServiceClient;
import dev.patika.feignclient.client.SmsServiceClient;
import dev.patika.feignclient.model.Customer;
import dev.patika.feignclient.model.Sms;
import feign.FeignException;
import feign.Response;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/credit-apply")
@RequiredArgsConstructor
public class ApplyController {
    private final CustomerServiceClient customerServiceClient;
    private final ScoreServiceClient scoreServiceClient;
    private final SmsServiceClient smsServiceClient;

    @GetMapping
    public ResponseEntity save(@RequestParam String ssid) throws JsonProcessingException {
        /* TODO - Check customer with SSID */
        Customer customer = null;
        int creditScore = 0;
        try {
            ResponseEntity<Customer> responseCustomer = this.customerServiceClient.getCustomerBySsid(ssid);
            customer = responseCustomer.getBody();
        }catch (FeignException ex){
            return new ResponseEntity(new ObjectMapper().readValue(ex.contentUTF8(), Map.class), HttpStatus.BAD_REQUEST);
        }

        /* TODO - Check credit score */
        try {
            ResponseEntity<Map<String, Object>> responseScore = this.scoreServiceClient.getCreditScoreBySSID(ssid);
            Map<String, Object> result = responseScore.getBody();
            if(Boolean.parseBoolean(result.get("success").toString()))
                creditScore = Integer.parseInt(result.get("scores").toString());
        }catch (FeignException ex){
            return new ResponseEntity(new ObjectMapper().readValue(ex.contentUTF8(), Map.class), HttpStatus.BAD_REQUEST);
        }

        /* TODO - Send result sms */
        CreditLimitResult result = checkCreditLimit(creditScore, customer.getSalary());
        Sms sms = prepareSms(customer, creditScore, result);
        return new ResponseEntity(this.smsServiceClient.sendSms(sms), HttpStatus.OK);
    }

    public CreditLimitResult checkCreditLimit(int creditScore, double salary){
        CreditLimitResult result = new CreditLimitResult();
        if(creditScore < 500) {
            result.setStatus(false);
            result.setLimit(0);
        }
        else if(creditScore < 1000){
            if(salary < 5000){
                result.setStatus(true);
                result.setLimit(10000);
            } else {
                result.setStatus(true);
                result.setLimit(20000);
            }
        } else{
            result.setStatus(true);
            result.setLimit(salary * 4);
        }

        return result;
    }

    public Sms prepareSms(Customer customer, int creditScore, CreditLimitResult result){
        String message = "";
        if(result.isStatus())
            message = "Dear " + customer.getFullName() + ", the result of your loan application is positive. Your credit limit: " + result.getLimit() + " ₺";
        else
            message = "Dear " + customer.getFullName() + ", the result of your loan application is negative.";
        Sms sms = new Sms();
        sms.setTimestamp(System.currentTimeMillis());
        sms.setSsid(customer.getSsid());
        sms.setPhone(customer.getPhone());
        sms.setCreditScore(creditScore);
        sms.setSalary(customer.getSalary());
        sms.setCreditLimit(result.getLimit());
        sms.setCreditStatus(result.isStatus());
        sms.setMessage(message);
        return sms;
    }
}
