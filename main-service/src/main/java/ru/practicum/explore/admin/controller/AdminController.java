package ru.practicum.explore.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explore.admin.service.AdminService;
import ru.practicum.explore.category.dto.CategoryDto;
import ru.practicum.explore.category.dto.NewCategoryDto;
import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.dto.NewCompilationDto;
import ru.practicum.explore.event.dto.AdminUpdateEventRequest;
import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.status.Status;
import ru.practicum.explore.user.dto.NewUserRequest;
import ru.practicum.explore.user.dto.UserDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/events")
    public Collection<EventFullDto> getAllEvents(@RequestParam List<Long> users,
                                                 @RequestParam List<Status> states,
                                                 @RequestParam List<Long> categories,
                                                 @RequestParam String rangeStart,
                                                 @RequestParam String rangeEnd,
                                                 @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                                 @Positive @RequestParam(defaultValue = "10") Integer size) {
        Map<String, Object> parameters = Map.of(
                "users", users,
                "states", states,
                "categories", categories,
                "rangeStart", rangeStart,
                "rangeEnd", rangeEnd,
                "from", from,
                "size", size
        );
        log.info("Admin Get events by parameters {}", parameters);
        return adminService.getAllEvents(parameters);
    }

    @PutMapping("/events/{eventId}")
    public EventFullDto putEvent(@PathVariable Long eventId,
                                 @RequestBody AdminUpdateEventRequest adminUpdateEventRequest) {
        log.info("Admin Put eventid={}", eventId);
        return adminService.putEvent(eventId, adminUpdateEventRequest);
    }

    @PatchMapping("/events/{eventId}/publish")
    public EventFullDto approvePublishEvent(@PathVariable Long eventId) {
        log.info("Admin approve publish eventId={}", eventId);
        return adminService.approvePublishEvent(eventId);
    }

    @PatchMapping("/events/{eventId}/reject")
    public EventFullDto approveRejectEvent(@PathVariable Long eventId) {
        log.info("Admin approve reject eventId={}", eventId);
        return adminService.approveRejectEvent(eventId);
    }

    @PatchMapping("/categories")
    public CategoryDto patchCategory(@RequestBody CategoryDto categoryDto) {
        log.info("Admin patch category");
        return adminService.patchCategory(categoryDto);
    }

    @PostMapping("/categories")
    public CategoryDto postCategory(@RequestBody NewCategoryDto newCategoryDto) {
        log.info("Admin post category");
        return adminService.postCategory(newCategoryDto);
    }

    @DeleteMapping("/categories/{catId}")
    public void deleteCategory(@PathVariable Long catId) {
        log.info("Admin delete category");
        adminService.deleteCategory(catId);
    }

    @GetMapping("/users")
    public Collection<UserDto> getAllUsers(@RequestParam List<Long> ids,
                                           @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                           @Positive @RequestParam(defaultValue = "10") Integer size) {
        log.info("Admin get all users");
        return adminService.getAllUsers(ids, from, size);
    }

    @PostMapping("/users")
    public UserDto postUser(@RequestBody NewUserRequest newUserRequest) {
        log.info("Admin post user");
        return adminService.postUser(newUserRequest);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        log.info("Admin delete user by id={}", userId);
        adminService.deleteUser(userId);
    }

    @PostMapping("/compilations")
    public CompilationDto createCompilation(@RequestBody NewCompilationDto newCompilationDto) {
        log.info("Admin post compilation");
        return adminService.createCompilation(newCompilationDto);
    }

    @DeleteMapping("/compilations/{compId}")
    public void deleteCompilation(@PathVariable Long compId) {
        log.info("Admin delete comtilation id={}", compId);
        adminService.deleteCompilation(compId);
    }

    @DeleteMapping("/compilations/{compId}/events/{eventId}")
    public void deleteEventInCompilation(@PathVariable Long compId, @PathVariable Long eventId) {
        log.info("Admin delete event id={} in compilation id={}", eventId, compId);
        adminService.deleteEventInCompilation(compId, eventId);
    }

    @PatchMapping("/compilations/{compId}/events/{eventId}")
    public void addEventInCompilation(@PathVariable Long compId, @PathVariable Long eventId) {
        log.info("Admin add event id={} in compilation id={}", eventId, compId);
        adminService.addEventInCompilation(compId, eventId);
    }

    @DeleteMapping("/compilations/{compId}/pin")
    public void unpinCompilation(@PathVariable Long compId) {
        log.info("Admin unpin compilation id={}", compId);
        adminService.unpinCompilation(compId);
    }

    @PatchMapping("/compilations/{compId}/pin")
    public void pinCompilation(@PathVariable Long compId) {
        log.info("Admin pin compilation id={}", compId);
        adminService.pinCompilation(compId);
    }
}
