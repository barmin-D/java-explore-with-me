package ru.practicum.explore.event.mapper;

import org.mapstruct.MappingTarget;
import ru.practicum.explore.category.model.Category;
import ru.practicum.explore.event.dto.*;
import ru.practicum.explore.event.location.model.Location;
import ru.practicum.explore.event.model.Event;
import ru.practicum.explore.user.model.User;

import java.time.LocalDateTime;

public interface EventMapper {

    EventFullDto toEventFullDto(Event event);

    EventShortDto toEventShortDto(Event event);

    Event toEvent(NewEventDto newEventDto, User user, Location location, Category category, LocalDateTime eventDate);

    void updateEventFromNewEventDto(UpdateEventRequest updateEventRequest, @MappingTarget Event event);

    void updateEventFromAdminUpdateEventRequest(AdminUpdateEventRequest adminUpdateEventRequest, Event event);
}
