package com.dutchviking.iot.app.controller;

import com.dutchviking.iot.app.model.Device;
import com.dutchviking.iot.app.model.dto.DeviceDto;
import com.dutchviking.iot.app.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<DeviceDto> getAllDevices() {
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public DeviceDto getDeviceById(@PathVariable Long id) {
        return deviceService.getById(id);
    }

    @PostMapping
    public Device addDevice(@RequestBody DeviceDto dto) {
        return deviceService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteById(id);
    }



    @PatchMapping("/{id}/update-name/{name}")
    public ResponseEntity<DeviceDto> updateDeviceName(@PathVariable Long id, @PathVariable String name) {
        DeviceDto dto = deviceService.updateName(id, name);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}/update-type/{type}")
    public ResponseEntity<DeviceDto> updateDeviceType(@PathVariable Long id, @PathVariable String type) {
        DeviceDto dto = deviceService.updateType(id, type);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}/update-status/{status}")
    public ResponseEntity<DeviceDto> updateDeviceStatus(@PathVariable Long id, @PathVariable String status) {
        DeviceDto dto = deviceService.updateStatus(id, status);
        return ResponseEntity.ok(dto);
    }

}
