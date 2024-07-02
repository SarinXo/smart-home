package com.spring.smarthome.mapper;

import com.spring.smarthome.model.dto.DeviceResponseDto;
import com.spring.smarthome.model.entity.DeviceEntity;
import org.springframework.stereotype.Component;

@Component
public class FromDeviceEntityToDto implements Mapper<DeviceEntity, DeviceResponseDto> {
    @Override
    public DeviceResponseDto map(DeviceEntity entity) {
        return DeviceResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .alias(entity.getAlias())
                .description(entity.getDescription())
                .homeId(entity.getHomeId())
                .lastUsage(entity.getLastUsage())
                .build();
    }

}