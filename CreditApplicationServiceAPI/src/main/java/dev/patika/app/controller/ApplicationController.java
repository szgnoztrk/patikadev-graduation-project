package dev.patika.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit-application")
public class ApplicationController {
    @GetMapping
    public void saveApplication(@RequestParam String ssid) {

        /* TODO - Check customer with SSID */
        /* TODO - Check credit score */
        /* TODO - Send result sms */
        /* TODO - Log for database result sms */

    }
}
