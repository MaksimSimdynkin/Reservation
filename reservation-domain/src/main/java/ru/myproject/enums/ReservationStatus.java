package ru.myproject.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReservationStatus {
    PENDING("В обработке"),
    CREATED("Создана"),
    CANCELLED("Отменена");

    private final String description;
}
