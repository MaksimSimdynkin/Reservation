package ru.myproject.dto;

import lombok.Builder;

import java.time.LocalDateTime;

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
