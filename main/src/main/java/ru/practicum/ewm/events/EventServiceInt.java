package ru.practicum.ewm.events;

import ru.practicum.ewm.events.dto.*;
import ru.practicum.ewm.exceptions.ForbiddenException;
import ru.practicum.ewm.exceptions.NotFoundException;
import ru.practicum.ewm.exceptions.ValidationException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

public interface EventServiceInt {
    EventFullDto addEvent(Long userId, NewEventDto newEventDto) throws NotFoundException, ValidationException;

    EventFullDto updateEventByOwner(Long userId, Long eventId, UpdateEventUserRequest updateEvent) throws NotFoundException, ForbiddenException, ValidationException;

    EventFullDto updateEventByAdmin(Long eventId, UpdateEventAdminRequest updateEvent) throws NotFoundException, ForbiddenException, ValidationException;

    List<EventShortDto> getEventsByOwner(Long userId, Integer from, Integer size);

    EventFullDto getEventByOwner(Long userId, Long eventId) throws NotFoundException;

    List<EventFullDtoWithViews> getEventsByAdminParams(List<Long> users, List<String> states, List<Long> categories, LocalDateTime rangeStart, LocalDateTime rangeEnd, Integer from, Integer size) throws ValidationException;

    List<EventShortDtoWithViews> getEvents(String text, List<Long> categories, Boolean paid, LocalDateTime rangeStart, LocalDateTime rangeEnd, Boolean onlyAvailable, String sort, Integer from, Integer size, HttpServletRequest request) throws ValidationException, NotFoundException;

    EventFullDtoWithViews getEventById(Long eventId, HttpServletRequest request) throws NotFoundException;

}
