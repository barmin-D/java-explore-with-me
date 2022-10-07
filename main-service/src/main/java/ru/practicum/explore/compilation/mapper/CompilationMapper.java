package ru.practicum.explore.compilation.mapper;

import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.dto.NewCompilationDto;
import ru.practicum.explore.compilation.model.Compilation;
import ru.practicum.explore.event.dto.EventShortDto;
import ru.practicum.explore.event.model.Event;

import java.util.List;

public interface CompilationMapper {
    NewCompilationDto toNewCompilationDto(Compilation compilation, List<Long> ids);

    Compilation toCompilation(NewCompilationDto newCompilationDto, List<Event> events);

    CompilationDto toCompilationDto(Compilation compilation, List<EventShortDto> list);
}
