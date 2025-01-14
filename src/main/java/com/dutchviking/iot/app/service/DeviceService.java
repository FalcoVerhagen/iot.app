package com.dutchviking.iot.app.service;

import com.dutchviking.iot.app.model.Device;
import com.dutchviking.iot.app.model.dto.DeviceDto;

import java.util.List;

public interface DeviceService {
    List<DeviceDto> findAll();
    DeviceDto getById(Long id);
    Device save(DeviceDto dto);
    void deleteById(Long id);
    DeviceDto updateName(Long id, String name);
    DeviceDto updateType(Long id, String type);
    DeviceDto updateStatus(Long id, String status);
}
