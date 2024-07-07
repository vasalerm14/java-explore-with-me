package ru.practicum.ewm.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.practicum.ewm.locations.LocationDto;

import javax.validation.constraints.Future;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static ru.practicum.ewm.util.DateConstant.DATE_TIME_PATTERN;

public interface UpdateEventRequest {

    @Size(min = 20, max = 2000)
    String getAnnotation();

    Long getCategory();

    @Size(min = 20, max = 7000)
    String getDescription();

    @Future
    @JsonFormat(pattern = DATE_TIME_PATTERN)
    LocalDateTime getEventDate();

    LocationDto getLocation();

    Boolean getPaid();

    @PositiveOrZero
    Integer getParticipantLimit();

    Boolean getRequestModeration();

    String getStateAction();

    @Size(min = 3, max = 120)
    String getTitle();
}
