package ru.myproject.dto;

import lombok.Builder;

@Builder
public record RequestRoom(
        Integer number,
        Integer floor,
        Integer countRooms
) {
}
