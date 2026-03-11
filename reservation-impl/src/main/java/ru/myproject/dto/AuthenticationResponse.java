package ru.myproject.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String email,
        String token
) {
}
