package com.spring.smarthome.controller.graphql;

import com.spring.smarthome.model.dto.DeviceRequestDto;
import com.spring.smarthome.model.dto.DeviceResponseDto;
import com.spring.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GlobalGraphQlController {
    private final DeviceService deviceService;

    public GlobalGraphQlController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @QueryMapping
    public List<DeviceResponseDto> allDevices(@Argument Integer homeId) {
        return deviceService.getAllDevices(homeId);
    }

    @MutationMapping
    public Boolean deleteDevice(@Argument Integer deviceId) {
        deviceService.deleteById(deviceId);
        return true;
    }

    @MutationMapping
    public DeviceResponseDto saveDevice(@Argument DeviceRequestDto device) {
        return deviceService.save(device);
    }

    @MutationMapping
    public DeviceResponseDto setAlias(@Argument Integer deviceId, @Argument String alias) {
        return deviceService.changeAlias(deviceId, alias);
    }
}
