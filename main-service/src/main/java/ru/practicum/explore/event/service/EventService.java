package ru.practicum.explore.event.service;

import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.dto.EventShortDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface EventService {
    Collection<EventShortDto> getAll(Map<String, Object> parameters);

    Optional<EventFullDto> getEvent(Long id);

    void saveInStatService(HttpServletRequest request);
}
