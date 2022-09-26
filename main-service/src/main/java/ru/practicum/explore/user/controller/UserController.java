package ru.practicum.explore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.dto.EventShortDto;
import ru.practicum.explore.event.dto.NewEventDto;
import ru.practicum.explore.request.dto.ParticipationRequestDto;
import ru.practicum.explore.user.service.UserService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/events")
    public Collection<EventShortDto> findAllEventsByUserId(@PathVariable Long userId,
                                                           @RequestParam(defaultValue = "0") Integer from,
                                                           @RequestParam(defaultValue = "10") Integer size) {
        return userService.findAllEventsByUserId(userId,from,size);
    }

    @PatchMapping("/{userId}/events")
    public EventFullDto patchEventByUser(@PathVariable Long userId, @RequestBody NewEventDto newEventDto) {
        return userService.patchEventByUser(userId, newEventDto);
    }

    @PostMapping("/{userId}/events")
    public EventFullDto postEvent(@PathVariable Long userId, @RequestBody NewEventDto newEventDto) {
        return userService.postEvent(userId, newEventDto);
    }

    @GetMapping("/{userId}/events/{eventId}")
    public EventFullDto getEventFull(@PathVariable Long userId, @PathVariable Long eventId) {
        return userService.getEventFull(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}")
    public EventFullDto cancelEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        return userService.cancelEvent(userId, eventId);
    }

    @GetMapping("/{userId}/events/{eventId}/requests")
    public ParticipationRequestDto getRequestByUser(@PathVariable Long userId, @PathVariable Long eventId){
        return userService.getRequestByUser(userId,eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests/{reqId}/confirm")
    public ParticipationRequestDto approveConfirmUserByEvent(@PathVariable Long userId, @PathVariable Long eventId,
                                                             @PathVariable Long reqId) {
        return userService.approveConfirmUserByEvent(userId, eventId, reqId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests/{reqId}/reject")
    public ParticipationRequestDto approveRejectUserByEvent(@PathVariable Long userId, @PathVariable Long eventId,
                                                            @PathVariable Long reqId) {
        return userService.approveRejectUserByEvent(userId, eventId, reqId);
    }

    @GetMapping("/{userId}/requests")
    public Collection<ParticipationRequestDto> getRequestsByUser(@PathVariable String userId){
        return userService.getRequestsByUser(userId);
    }
    @PostMapping("/{userId}/requests")
    public ParticipationRequestDto postRequestUser(@PathVariable String userId,@RequestParam Integer eventId){
        return userService.postRequestUser(userId,eventId);
    }

    @PatchMapping("/{userId}/requests/{requestId}/cancel")
    public ParticipationRequestDto cancelRequestByUser(@PathVariable String userId, @PathVariable String requestId){
        return userService.cancelRequestByUser(userId,requestId);
    }
}
