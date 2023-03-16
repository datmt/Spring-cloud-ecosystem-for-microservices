package com.datmt.spring_cloud.billing_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BillingController {
    @GetMapping
    public String getBilling() {
        return "Billing works";
    }
}
