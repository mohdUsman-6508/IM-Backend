package com.BP.InventoryManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HealthCheckController {
    @GetMapping
    public String health() {
        return "I am working fine...";
    }
}
