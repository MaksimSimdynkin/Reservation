package ru.myproject.dto;

import lombok.Builder;

@Builder
public record RequestUsers(
        String firstName,
        String lastName,
        int phone,
        int age
) {
}
