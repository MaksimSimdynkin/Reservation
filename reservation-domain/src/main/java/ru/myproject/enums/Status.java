package ru.myproject.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {
    PENDING("В обработке"),
    CREATED("Создана"),
    CANCELLED("Отменена");

    private final String description;
}
