package ru.practicum.explore.compilation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explore.compilation.dto.CompilationDto;
import ru.practicum.explore.compilation.service.CompilationService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/compilations")
@Slf4j
public class CompilationController {
    private final CompilationService compilationService;

    @Autowired
    public CompilationController(CompilationService compilationService) {
        this.compilationService = compilationService;
    }

    @GetMapping
    public Collection<CompilationDto> getAll(@RequestParam Boolean pinned,
                                             @RequestParam(defaultValue = "0") Integer from,
                                             @RequestParam(defaultValue = "10") Integer size) {
        log.info("find all Compilation");
        return compilationService.getAll(pinned, from, size);
    }

    @GetMapping("/{compId}")
    public Optional<CompilationDto> get(@PathVariable Long compId) {
        log.info("Get compilation id={}",compId);
        return compilationService.get(compId);
    }
}
