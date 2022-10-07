package ru.practicum.explore.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndpointHit {
    private Integer id;
    private String app;
    private String uri;
    private String ip;
    private String timestamp;
}
