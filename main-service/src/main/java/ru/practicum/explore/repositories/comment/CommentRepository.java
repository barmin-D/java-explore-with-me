package ru.practicum.explore.repositories.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explore.models.comment.Comment;
import ru.practicum.explore.models.event.Event;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByEventOrderByCreated(Event event);
}
