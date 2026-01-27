package ru.myproject.enums;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusRoom {
    AVAILABLE("Доступна"),
    BLOCKED("Заблокирована");

    private final String description;
}
