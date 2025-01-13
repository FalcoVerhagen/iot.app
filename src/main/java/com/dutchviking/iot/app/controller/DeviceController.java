package com.dutchviking.iot.app.controller;

import com.dutchviking.iot.app.model.Device;
import com.dutchviking.iot.app.repository.DeviceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceRepository.deleteById(id);
    }
}
