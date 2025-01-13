package com.dutchviking.iot.app.repository;

import com.dutchviking.iot.app.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
