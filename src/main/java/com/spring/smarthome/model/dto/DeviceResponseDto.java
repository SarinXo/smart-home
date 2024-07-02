package com.spring.smarthome.model.dto;


import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record DeviceResponseDto(
        Integer id,
        String name,
        String alias,
        String description,
        OffsetDateTime lastUsage,
        Integer homeId
) { }
