package ru.practicum.explore.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto обновление комментария
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateComment {
    private Long id;
    private String text;
}
