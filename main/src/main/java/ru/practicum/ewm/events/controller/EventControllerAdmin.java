package ru.practicum.ewm.events.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.events.EventService;
import ru.practicum.ewm.events.dto.EventFullDto;
import ru.practicum.ewm.events.dto.EventFullDtoWithViews;
import ru.practicum.ewm.events.dto.EventSearchCriteria;
import ru.practicum.ewm.events.dto.UpdateEventAdminRequest;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/events")
public class EventControllerAdmin {
    private final EventService eventService;

    @PatchMapping("/{eventId}")
    public EventFullDto updateEventByAdmin(@PathVariable Long eventId,
                                           @RequestBody @Valid UpdateEventAdminRequest updateEventAdminRequest) {
        return eventService.updateEventByAdmin(eventId, updateEventAdminRequest);
    }

    @GetMapping
    public List<EventFullDtoWithViews> getEventsByAdminParams(@Valid EventSearchCriteria searchCriteria) {
        return eventService.getEventsByAdminParams(
                searchCriteria.getUsers(),
                searchCriteria.getStates(),
                searchCriteria.getCategories(),
                searchCriteria.getRangeStart(),
                searchCriteria.getRangeEnd(),
                searchCriteria.getFrom(),
                searchCriteria.getSize()
        );
    }
}
