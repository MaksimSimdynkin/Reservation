package ru.myproject.service;

import org.jspecify.annotations.Nullable;
import ru.myproject.dto.RequestRoom;
import ru.myproject.dto.ResponseRoom;

import java.util.List;
import java.util.UUID;

public interface ServiceRoom {

    ResponseRoom createRooms(RequestRoom requestRoom);

    ResponseRoom updateRoom(UUID id, RequestRoom requestRoom);

    List<ResponseRoom> getAllRooms();
}
