package ru.practicum.explore.compilation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.explore.compilation.repository.CompilationRepository;

@Service
public class CompilationServiceImpl implements CompilationService {
    private CompilationRepository compilationRepository;

    @Autowired
    public CompilationServiceImpl(CompilationRepository compilationRepository) {
        this.compilationRepository = compilationRepository;
    }
}
