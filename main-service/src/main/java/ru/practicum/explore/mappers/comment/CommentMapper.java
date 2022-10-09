package ru.practicum.explore.mappers.comment;


import ru.practicum.explore.dto.comment.CommentDto;
import ru.practicum.explore.dto.comment.UpdateComment;
import ru.practicum.explore.models.comment.Comment;
import ru.practicum.explore.models.event.Event;
import ru.practicum.explore.models.user.User;

/**
 * Интерфейс маппера комментариев
 */
public interface CommentMapper {
    /*
    Метод маппера из модели в dto комментария
    */
    CommentDto toCommentDto(Comment comment);
    /*
    Метод маппера из dto комментария в модель
    */
    Comment toComment(CommentDto commentDto, User user, Event event);
    /*
    Метод маппера обновление комментария
    */
    void updateCommentFromUpdateComment(UpdateComment updateComment, Comment comment);
}
