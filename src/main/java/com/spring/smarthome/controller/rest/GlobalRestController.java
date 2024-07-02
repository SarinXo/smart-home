package com.spring.smarthome.controller.rest;

import com.spring.smarthome.model.dto.DeviceRequestDto;
import com.spring.smarthome.model.dto.DeviceResponseDto;
import com.spring.smarthome.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GlobalRestController {
    private final DeviceService deviceService;

    public GlobalRestController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @DeleteMapping("/devices/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable Integer deviceId) {
        deviceService.deleteById(deviceId);
    }

    @GetMapping("/home/{homeId}/devices")
    public ResponseEntity<List<DeviceResponseDto>> getAllDevices(@PathVariable Integer homeId) {
        var list = deviceService.getAllDevices(homeId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/devices")
    public ResponseEntity<DeviceResponseDto> saveDevice(@RequestBody DeviceRequestDto dto){
        var response = deviceService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/devices")
    public ResponseEntity<DeviceResponseDto> setAlias(
            @RequestParam Integer deviceId,
            @RequestParam String alias
    ) {
        var response = deviceService.changeAlias(deviceId, alias);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
