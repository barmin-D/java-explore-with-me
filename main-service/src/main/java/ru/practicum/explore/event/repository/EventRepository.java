package ru.practicum.explore.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.practicum.explore.event.model.Event;
@Component
public interface EventRepository extends JpaRepository<Event,Long> {
}
