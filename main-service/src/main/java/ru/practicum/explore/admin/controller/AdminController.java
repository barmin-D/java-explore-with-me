package ru.practicum.explore.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explore.admin.service.AdminService;
import ru.practicum.explore.category.dto.CategoryDto;
import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.dto.NewCompilationDto;
import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.dto.NewEventDto;
import ru.practicum.explore.user.dto.UserDto;

import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/events")
    public Collection<EventFullDto> getAllEvents(@RequestParam List<Integer> users,
                                                 @RequestParam String states,
                                                 @RequestParam List<Integer> categories,
                                                 @RequestParam LocalDateTime rangeStart,
                                                 @RequestParam LocalDateTime rangeEnd,
                                                 @RequestParam(defaultValue = "0") Integer from,
                                                 @RequestParam(defaultValue = "10") Integer size) {
        Map<String, Object> parameters = Map.of(
                "users", users,
                "states", states,
                "categories", categories,
                "rangeStart", rangeStart,
                "rangeEnd", rangeEnd,
                "from", from,
                "size", size
        );
        return adminService.getAllEvents(parameters);
    }

    @PutMapping("/events/{eventId}")
    public EventFullDto putEvent(@PathVariable Long eventId, @RequestBody NewEventDto newEventDto) {
        return adminService.putEvent(eventId, newEventDto);
    }

    @PatchMapping("/events/{eventId}/publish")
    public EventFullDto approvePublishEvent(@PathVariable Long eventId) {
        return adminService.approvePublishEvent(eventId);
    }

    @PatchMapping("/events/{eventId}/reject")
    public EventFullDto approveRejectEvent(@PathVariable Long eventId) {
        return adminService.approveRejectEvent(eventId);
    }
    @PatchMapping("/categories")
    public CategoryDto patchCategory(@RequestBody CategoryDto categoryDto){
        return adminService.patchCategory(categoryDto);
    }

    @PostMapping("/categories")
    public CategoryDto postCategory(@RequestBody CategoryDto categoryDto){
        return adminService.postCategory(categoryDto);
    }

    @DeleteMapping("/categories/{catId}")
    public void deleteCategory(@PathVariable Long catId){
        adminService.deleteCategory(catId);
    }

    @GetMapping("/users")
    public Collection<UserDto> getAllUsers(@RequestParam List<Integer> ids,
                              @RequestParam(defaultValue = "0") Integer from,
                              @RequestParam(defaultValue = "10") Integer size){
        return adminService.getAllUsers(ids,from,size);
    }

    @PostMapping("/users")
    public UserDto postUser(@RequestBody UserDto userDto){
        return adminService.postUser(userDto);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        adminService.deleteUser(userId);
    }

    @PostMapping("/compilations")
    public CompilationDto createCompilation(@RequestBody NewCompilationDto newCompilationDto){
        return adminService.createCompilation(newCompilationDto);
    }

    @DeleteMapping("/compilations/{compId}")
    public void deleteCompilation(@PathVariable Long compId){
        adminService.deleteCompilation(compId);
    }

    @DeleteMapping("/compilations/{compId}/events/{eventId}")
    public void deleteEventInCompilation(@PathVariable Long compId, @PathVariable Long eventId){
        adminService.deleteEventInCompilation(compId,eventId);
    }

    @PatchMapping("/compilations/{compId}/events/{eventId}")
    public void addEventInCompilation(@PathVariable Long compId, @PathVariable Long eventId){
        adminService.addEventInCompilation(compId,eventId);
    }

    @DeleteMapping("/compilations/{compId}/pin")
    public void UnpinCompilation(@PathVariable Long compId){
        adminService.UnpinCompilation(compId);
    }

    @PatchMapping("/compilations/{compId}/pin")
    public void pinCompilation(@PathVariable Long compId){
        adminService.pinCompilation(compId);
    }
}
