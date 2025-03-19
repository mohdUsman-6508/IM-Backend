package com.BP.InventoryManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HealthCheckController {
    @GetMapping("/")
    public String health() {
        return "I am working fine...";
    }

    @GetMapping("/hello")
    public String[] sayHello() {
        String[] arr={"Hello","World!"};
        return  arr;
    }


}
