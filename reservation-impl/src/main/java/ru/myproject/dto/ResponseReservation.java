package ru.myproject.dto;

import lombok.Builder;
import ru.myproject.entity.Room;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ResponseReservation(
        UUID id,
        String name,
        Room room,
        LocalDateTime firstDate,
        LocalDateTime lastDate
) {
}
