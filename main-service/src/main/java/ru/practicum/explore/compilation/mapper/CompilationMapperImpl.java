package ru.practicum.explore.compilation.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.dto.NewCompilationDto;
import ru.practicum.explore.compilation.model.Compilation;
import ru.practicum.explore.event.dto.EventShortDto;
import ru.practicum.explore.event.model.Event;

import java.util.List;

@Component
public class CompilationMapperImpl implements CompilationMapper {
    @Override
    public NewCompilationDto toNewCompilationDto(Compilation compilation, List<Long> ids) {
        if (compilation == null) {
            return null;
        }
        return NewCompilationDto.builder()
                .id(compilation.getId())
                .events(ids)
                .pinned(compilation.getPinned())
                .title(compilation.getTitle())
                .build();
    }

    @Override
    public Compilation toCompilation(NewCompilationDto newCompilationDto, List<Event> events) {
        if (newCompilationDto == null) {
            return null;
        }
        return Compilation.builder()
                .id(newCompilationDto.getId())
                .events(events)
                .pinned(newCompilationDto.getPinned())
                .title(newCompilationDto.getTitle())
                .build();
    }

    @Override
    public CompilationDto toCompilationDto(Compilation compilation, List<EventShortDto> list) {
        if (compilation == null) {
            return null;
        }
        return CompilationDto.builder()
                .id(compilation.getId())
                .events(list)
                .pinned(compilation.getPinned())
                .title(compilation.getTitle())
                .build();
    }
}
