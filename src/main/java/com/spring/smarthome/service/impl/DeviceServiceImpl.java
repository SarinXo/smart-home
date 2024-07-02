package com.spring.smarthome.service.impl;

import com.spring.smarthome.mapper.Mapper;
import com.spring.smarthome.model.dto.DeviceRequestDto;
import com.spring.smarthome.model.dto.DeviceResponseDto;
import com.spring.smarthome.model.entity.DeviceEntity;
import com.spring.smarthome.repository.DeviceRepository;
import com.spring.smarthome.service.DeviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;
    private final Mapper<DeviceRequestDto, DeviceEntity> toEntityMapper;
    private final Mapper<DeviceEntity, DeviceResponseDto> toDtoMapper;

    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             Mapper<DeviceRequestDto, DeviceEntity> toEntityMapper,
                             Mapper<DeviceEntity, DeviceResponseDto> toDtoMapper) {
        this.repository = deviceRepository;
        this.toEntityMapper = toEntityMapper;
        this.toDtoMapper = toDtoMapper;
    }


    @Override
    public void deleteById(Integer deviceId) {
        repository.deleteById(deviceId);
    }

    @Override
    public List<DeviceResponseDto> getAllDevices(Integer homeId) {
        var listEntity = repository.findAllByHomeId(homeId);
        return listEntity.stream().map(toDtoMapper::map).toList();
    }

    @Override
    public DeviceResponseDto save(DeviceRequestDto dto) {
        var entityForSave = toEntityMapper.map(dto);
        var savedEntity = repository.save(entityForSave);
        return toDtoMapper.map(savedEntity);
    }

    @Override
    @Transactional
    public DeviceResponseDto changeAlias(Integer deviceId, String alias) {
        var optional = repository.findById(deviceId);
        var entity = optional.orElseThrow(() -> new RuntimeException("Не найден девайс с id = " + deviceId));
        entity.setAlias(alias);
        var savedEntity = repository.save(entity);
        return toDtoMapper.map(savedEntity);
    }
}
