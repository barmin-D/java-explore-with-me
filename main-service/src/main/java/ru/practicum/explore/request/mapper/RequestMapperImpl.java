package ru.practicum.explore.request.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.explore.request.dto.ParticipationRequestDto;
import ru.practicum.explore.request.model.ParticipationRequest;

@Component
public class RequestMapperImpl implements RequestMapper {
    @Override
    public ParticipationRequestDto toParticipationRequestDto(ParticipationRequest participationRequest) {
        return ParticipationRequestDto.builder()
                .id(participationRequest.getId())
                .created(participationRequest.getCreated())
                .event(participationRequest.getEvent())
                .requestor(participationRequest.getRequestor())
                .status(participationRequest.getStatus())
                .build();
    }

    @Override
    public ParticipationRequest toParticipationRequest(ParticipationRequestDto participationRequestDto) {
        return ParticipationRequest.builder()
                .id(participationRequestDto.getId())
                .created(participationRequestDto.getCreated())
                .event(participationRequestDto.getEvent())
                .requestor(participationRequestDto.getRequestor())
                .status(participationRequestDto.getStatus())
                .build();
    }
}
