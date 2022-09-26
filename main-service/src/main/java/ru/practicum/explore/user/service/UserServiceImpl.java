package ru.practicum.explore.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.explore.Error.ApiError;
import ru.practicum.explore.event.dto.EventFullDto;
import ru.practicum.explore.event.dto.EventShortDto;
import ru.practicum.explore.event.dto.NewEventDto;
import ru.practicum.explore.event.mapper.EventMapper;
import ru.practicum.explore.event.repository.EventRepository;
import ru.practicum.explore.request.dto.ParticipationRequestDto;
import ru.practicum.explore.request.mapper.RequestMapper;
import ru.practicum.explore.request.repository.ParticipationRequestRepository;
import ru.practicum.explore.user.mapper.UserMapper;
import ru.practicum.explore.user.repository.UserRepository;

import java.util.Collection;

@Service
class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private EventMapper eventMapper;
    private RequestMapper requestMapper;
    private UserRepository userRepository;
    private EventRepository eventRepository;
    private ParticipationRequestRepository participationRequestRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, EventMapper eventMapper, RequestMapper requestMapper,
                           UserRepository userRepository, EventRepository eventRepository,
                           ParticipationRequestRepository participationRequestRepository) {
        this.userMapper = userMapper;
        this.eventMapper = eventMapper;
        this.requestMapper = requestMapper;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.participationRequestRepository = participationRequestRepository;
    }

    @Override
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "События найдены", response = EventShortDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Запрос составлен с ошибкой", response = ApiError.class),
            @ApiResponse(code = 403, message = "Не выполнены условия для совершения операции", response = ApiError.class),
            @ApiResponse(code = 404, message = "Объект не найден", response = ApiError.class),
            @ApiResponse(code = 409, message = "Запрос приводит к нарушению целостности данных", response = ApiError.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера", response = ApiError.class) })
    public Collection<EventShortDto> findAllEventsByUserId(Long userId, Integer from, Integer size) {
       if(!userRepository.findById(userId).isPresent()){
           return new ApiError(404,"Объект не найден",)
       }
    }

    @Override
    public EventFullDto patchEventByUser(Long userId, NewEventDto newEventDto) {
        return null;
    }

    @Override
    public EventFullDto postEvent(Long userId, NewEventDto newEventDto) {
        return null;
    }

    @Override
    public EventFullDto getEventFull(Long userId, Long eventId) {
        return null;
    }

    @Override
    public EventFullDto cancelEvent(Long userId, Long eventId) {
        return null;
    }

    @Override
    public ParticipationRequestDto getRequestByUser(Long userId, Long eventId) {
        return null;
    }

    @Override
    public ParticipationRequestDto approveConfirmUserByEvent(Long userId, Long eventId, Long reqId) {
        return null;
    }

    @Override
    public ParticipationRequestDto approveRejectUserByEvent(Long userId, Long eventId, Long reqId) {
        return null;
    }

    @Override
    public Collection<ParticipationRequestDto> getRequestsByUser(String userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto postRequestUser(String userId, Integer eventId) {
        return null;
    }

    @Override
    public ParticipationRequestDto cancelRequestByUser(String userId, String requestId) {
        return null;
    }
}
