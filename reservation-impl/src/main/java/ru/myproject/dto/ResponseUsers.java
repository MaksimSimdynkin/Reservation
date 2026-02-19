package ru.myproject.dto;

import lombok.Builder;

@Builder
public record ResponseUsers(
        String firstName,
        String lastName,
        String phone,
        int age
) {
}
