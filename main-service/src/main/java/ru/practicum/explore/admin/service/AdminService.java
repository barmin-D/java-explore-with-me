package ru.practicum.explore.admin.service;

import ru.practicum.explore.category.dto.CategoryDto;
import ru.practicum.explore.category.dto.NewCategoryDto;
import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.dto.NewCompilationDto;
import ru.practicum.explore.event.dto.AdminUpdateEventRequest;
import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.user.dto.NewUserRequest;
import ru.practicum.explore.user.dto.UserDto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AdminService {
    Collection<EventFullDto> getAllEvents(Map<String, Object> parameters);

    EventFullDto putEvent(Long eventId, AdminUpdateEventRequest adminUpdateEventRequest);

    EventFullDto approvePublishEvent(Long eventId);

    EventFullDto approveRejectEvent(Long eventId);

    CategoryDto patchCategory(CategoryDto categoryDto);

    CategoryDto postCategory(NewCategoryDto newCategoryDto);

    void deleteCategory(Long catId);

    Collection<UserDto> getAllUsers(List<Long> ids, Integer from, Integer size);

    UserDto postUser(NewUserRequest newUserRequest);

    void deleteUser(Long userId);

    CompilationDto createCompilation(NewCompilationDto newCompilationDto);

    void deleteCompilation(Long compId);

    void deleteEventInCompilation(Long compId, Long eventId);

    void addEventInCompilation(Long compId, Long eventId);

    void UnpinCompilation(Long compId);

    void pinCompilation(Long compId);
}
