package ru.myproject.dto;

import lombok.Builder;
import ru.myproject.enums.StatusRoom;

@Builder
public record ResponseRoom(
        int number,
        int floor,
        int countRooms,
        int count,
        StatusRoom statusRoom
) {
}
