package ru.myproject.dto;

import lombok.Builder;

@Builder
public record RegisterResponse(
        String firstName,
        String lastName,
        String phone,
        String email,
        String token
) {
}
