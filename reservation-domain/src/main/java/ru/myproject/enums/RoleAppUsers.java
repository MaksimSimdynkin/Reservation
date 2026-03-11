package ru.myproject.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RoleAppUsers {
    DEFAULT("Пользователь"),
    ADMIN("Админ");

    private final String description;
}
