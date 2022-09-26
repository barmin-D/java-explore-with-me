package ru.practicum.explore.event.location.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.explore.event.location.dto.LocationDto;
import ru.practicum.explore.event.location.model.Location;

@Component
public class LocationMapperImpl implements LocationMapper{
    @Override
    public LocationDto toLocationDto(Location location){
        return LocationDto.builder()
                .id(location.getId())
                .lat(location.getLat())
                .lon(location.getLon())
                .build();
    }

    @Override
    public Location toLocation(LocationDto locationDto){
        return Location.builder()
                .id(locationDto.getId())
                .lat(locationDto.getLat())
                .lon(locationDto.getLon())
                .build();
    }
}
