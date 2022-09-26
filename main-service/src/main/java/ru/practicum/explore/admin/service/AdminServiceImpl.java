package ru.practicum.explore.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.explore.category.repository.CategoryRepository;
import ru.practicum.explore.compilation.repository.CompilationRepository;
import ru.practicum.explore.event.repository.EventRepository;
import ru.practicum.explore.user.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {
    private CategoryRepository categoryRepository;
    private CompilationRepository compilationRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(CategoryRepository categoryRepository, CompilationRepository compilationRepository,
                            EventRepository eventRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.compilationRepository = compilationRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }
}
