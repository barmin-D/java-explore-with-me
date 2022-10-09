package ru.practicum.explore.mappers.comment;

import org.springframework.stereotype.Component;
import ru.practicum.explore.dto.comment.CommentDto;
import ru.practicum.explore.dto.comment.UpdateComment;
import ru.practicum.explore.models.comment.Comment;
import ru.practicum.explore.models.event.Event;
import ru.practicum.explore.models.user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto toCommentDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .authorName(comment.getAuthor().getName())
                .created(comment.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    @Override
    public Comment toComment(CommentDto commentDto, User user, Event event) {
        if (commentDto == null) {
            return null;
        }
        return Comment.builder()
                .id(commentDto.getId())
                .text(commentDto.getText())
                .event(event)
                .author(user)
                .created(LocalDateTime.now())
                .build();
    }

    @Override
    public void updateCommentFromUpdateComment(UpdateComment updateComment, Comment comment) {
        if (updateComment.getText() != null) {
            comment.setText(updateComment.getText());
        }
    }
}
