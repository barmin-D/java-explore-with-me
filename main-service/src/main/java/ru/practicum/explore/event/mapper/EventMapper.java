package ru.practicum.explore.event.mapper;

import ru.practicum.explore.event.dto.NewEventDto;
import ru.practicum.explore.event.model.Event;
import ru.practicum.explore.user.model.User;

public interface EventMapper {
    NewEventDto toNewEventDto(Event event);

    Event toEvent(NewEventDto newEventDto, User user);
}
