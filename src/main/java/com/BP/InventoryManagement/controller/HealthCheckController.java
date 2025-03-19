package com.BP.InventoryManagement.controller;

import com.BP.InventoryManagement.model.Device;
import com.BP.InventoryManagement.service.DeviceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
