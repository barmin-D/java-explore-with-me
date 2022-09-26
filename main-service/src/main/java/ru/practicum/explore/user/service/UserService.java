package ru.practicum.explore.user.service;

import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.dto.EventShortDto;
import ru.practicum.explore.event.dto.NewEventDto;
import ru.practicum.explore.request.dto.ParticipationRequestDto;

import java.util.Collection;

public interface UserService {
    Collection<EventShortDto> findAllEventsByUserId(Long userId, Integer from, Integer size);

    EventFullDto patchEventByUser(Long userId, NewEventDto newEventDto);

    EventFullDto postEvent(Long userId, NewEventDto newEventDto);

    EventFullDto getEventFull(Long userId, Long eventId);

    EventFullDto cancelEvent(Long userId, Long eventId);

    ParticipationRequestDto getRequestByUser(Long userId, Long eventId);

    ParticipationRequestDto approveConfirmUserByEvent(Long userId, Long eventId, Long reqId);

    ParticipationRequestDto approveRejectUserByEvent(Long userId, Long eventId, Long reqId);

    Collection<ParticipationRequestDto> getRequestsByUser(String userId);

    ParticipationRequestDto postRequestUser(String userId, Integer eventId);

    ParticipationRequestDto cancelRequestByUser(String userId, String requestId);
}
