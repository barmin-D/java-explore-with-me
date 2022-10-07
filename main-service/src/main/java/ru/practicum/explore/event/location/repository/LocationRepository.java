package ru.practicum.explore.event.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explore.event.location.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
