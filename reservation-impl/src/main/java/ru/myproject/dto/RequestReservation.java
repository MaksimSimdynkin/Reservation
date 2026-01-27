package ru.myproject.dto;

import lombok.Builder;
import ru.myproject.Room;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record RequestReservation(
        String firstName,
        String lastName,
        Integer phone,
        Integer age,
        LocalDateTime firstDate,
        LocalDateTime lastDate
) {
}
