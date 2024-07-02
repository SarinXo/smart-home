package com.spring.smarthome.model.dto;

public record DeviceRequestDto(
        String name,
        String alias,
        String description,
        Integer homeId
) { }
