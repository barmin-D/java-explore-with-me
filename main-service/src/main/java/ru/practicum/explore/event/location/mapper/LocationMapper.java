package ru.practicum.explore.event.location.mapper;

import ru.practicum.explore.event.location.dto.LocationDto;
import ru.practicum.explore.event.location.model.Location;

public interface LocationMapper {
    LocationDto toLocationDto(Location location);

    Location toLocation(LocationDto locationDto);
}
