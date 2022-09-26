package ru.practicum.explore.compilation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.practicum.explore.compilation.model.Compilation;
@Component
public interface CompilationRepository extends JpaRepository<Compilation, Long> {
}
