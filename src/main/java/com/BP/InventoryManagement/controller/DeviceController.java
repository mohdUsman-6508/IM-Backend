package com.BP.InventoryManagement.controller;

import com.BP.InventoryManagement.model.Device;
import com.BP.InventoryManagement.service.DeviceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class DeviceController {
    private final DeviceServiceImpl service;

    public DeviceController(DeviceServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDevice(@Valid @RequestBody Device device, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
            );
        }
        return service.saveDevice(device);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable Long id) {
        return service.getDevice(id);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<Device> getDeviceByName(@PathVariable String name) {
        return service.getDeviceByName(name);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Device> modifyDevice(@RequestBody Device device, @PathVariable Long id) {
        return service.modifyDevice(device, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable Long id) {
        return service.deleteDevice(id);
    }

    @GetMapping("/getAllDevices")
    public ResponseEntity<List<Device>> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/get/type/{type}")
    public ResponseEntity<Device> getDeviceByType(@PathVariable String type) {
        return service.getDeviceByType(type);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<Map<String, Object>>> getInventorySummary() {
        return service.inventorySummary();
    }

}
