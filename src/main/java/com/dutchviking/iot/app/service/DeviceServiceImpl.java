package com.dutchviking.iot.app.service;

import com.dutchviking.iot.app.exceptions.custom.CustomEntityNotFoundException;
import com.dutchviking.iot.app.model.Device;
import com.dutchviking.iot.app.model.dto.DeviceDto;
import com.dutchviking.iot.app.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public DeviceDto updateName(Long id, String name) {
        Device device = deviceRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException("Entity not found with id: " + id));
        device.setName(name);

        Device updatedDevice = deviceRepository.save(device);
        return mapToDeviceDto(updatedDevice);
    }

    @Override
    public DeviceDto updateType(Long id, String type) {
        Device device = deviceRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException("Entity not found with id: " + id));
        device.setType(type);

        Device updatedDevice = deviceRepository.save(device);
        return mapToDeviceDto(updatedDevice);
    }

    @Override
    public DeviceDto updateStatus(Long id, String status) {
        Device device = deviceRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException("UPDATE - Entity not found with id: " + id));
        device.setStatus(status);

        Device updatedDevice = deviceRepository.save(device);
        return mapToDeviceDto(updatedDevice);
    }

    @Override
    public List<DeviceDto> findAll() {
        List<Device> devices = deviceRepository.findAll();
        return devices.stream()
            .map(this::mapToDeviceDto)
            .collect(Collectors.toList());
    }

    @Override
    public DeviceDto getById(Long id) {
        Device device = deviceRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException("GET - Entity not found with ID: " + id));

        return mapToDeviceDto(device);
    }

    @Override
    public Device save(DeviceDto dto) {
        return deviceRepository.save(mapDeviceToDto(dto));
    }

    @Override
    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }

    private DeviceDto mapToDeviceDto(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setId(device.getId());
        dto.setName(device.getName());
        dto.setType(device.getType());
        dto.setStatus(device.getStatus());
        return dto;
    }

    private Device mapDeviceToDto(DeviceDto dto) {
        Device device = new Device();
        device.setName(dto.getName());
        device.setType(dto.getType());
        device.setStatus(dto.getStatus());
        return device;
    }

}
