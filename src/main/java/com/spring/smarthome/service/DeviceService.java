package com.spring.smarthome.service;

import com.spring.smarthome.model.dto.DeviceRequestDto;
import com.spring.smarthome.model.dto.DeviceResponseDto;

import java.util.List;

public interface DeviceService {
    void deleteById(Integer deviceId);

    List<DeviceResponseDto> getAllDevices(Integer homeId);

    DeviceResponseDto save(DeviceRequestDto dto);

    DeviceResponseDto changeAlias(Integer deviceId, String alias);
}
