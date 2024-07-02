package com.spring.smarthome.repository;

import com.spring.smarthome.model.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer> {
    @Query("select d from DeviceEntity d where d.homeId = :homeId")
    List<DeviceEntity> findAllByHomeId(@Param("homeId")Integer homeId);
}
