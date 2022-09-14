package com.datmt.spring_cloud.warehouse_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/debug")
@RestController
public class DebugController {

    @Value("${db.user}")
    private String dbUser;
    @GetMapping("/test")
    public String test() {
        return "DB USER: " + dbUser;
    }
}
