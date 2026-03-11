package ru.myproject.dto;

import lombok.Builder;

@Builder
public record RegisterRequest(
        String firstName,
        String lastName,
        String phone,
        int age,
        String email,
        String password
) {
}
