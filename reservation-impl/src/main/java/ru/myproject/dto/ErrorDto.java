package ru.myproject.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
        String status,
        int code,
        String message
) {
}
