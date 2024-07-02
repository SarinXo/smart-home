package com.spring.smarthome.mapper;

import com.spring.smarthome.model.dto.DeviceRequestDto;
import com.spring.smarthome.model.entity.DeviceEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class FromDeviceRequestToEntity implements Mapper<DeviceRequestDto, DeviceEntity> {
    @Override
    public DeviceEntity map(DeviceRequestDto dto) {
        return DeviceEntity.builder()
                .name(dto.name())
                .alias(dto.alias())
                .description(dto.description())
                .homeId(dto.homeId())
                .lastUsage(OffsetDateTime.now())
                .build();
    }

}
