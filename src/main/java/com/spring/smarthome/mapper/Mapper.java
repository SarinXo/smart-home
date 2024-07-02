package com.spring.smarthome.mapper;

@FunctionalInterface
public interface Mapper<FROM, TO>{
   TO map(FROM object);
}
