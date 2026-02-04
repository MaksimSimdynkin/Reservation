package ru.myproject.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusRoom {

    CLASSIC("Классическая"),
    BUSINESS("Бизнес"),
    LUXURY("Люкс");

    private final String description;
}
