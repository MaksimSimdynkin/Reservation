package ru.myproject.dto;

import lombok.Builder;

@Builder
public record ResponseUsers(
        String firstName,
        String lastName,
        int phone,
        int age
) {
}
