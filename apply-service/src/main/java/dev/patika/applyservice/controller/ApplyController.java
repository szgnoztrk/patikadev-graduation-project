package dev.patika.applyservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/credit-apply")
public class ApplyController {
    @Autowired
    private RestTemplate template;

    @GetMapping
    public void save(@RequestParam String ssid) {
        /* TODO - Check customer with SSID */
        ResponseEntity responseEntity = this.template.getForEntity();
        //Customer customer = (Customer) responseEntity.getBody();


        /* TODO - Check credit score */
        /* TODO - Send result sms */
        /* TODO - Log for database result sms */

    }
}
