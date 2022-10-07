package ru.practicum.explore.compilation.service;

import ru.practicum.explore.compilation.dto.CompilationDto;

import java.util.Collection;
import java.util.Optional;

public interface CompilationService {
    Collection<CompilationDto> getAll(Boolean pinned, Integer from, Integer size);

    Optional<CompilationDto> get(Long compId);
}
