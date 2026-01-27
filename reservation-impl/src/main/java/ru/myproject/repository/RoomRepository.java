package ru.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.myproject.Room;
import ru.myproject.dto.RequestRoom;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

    @Query
    Void addRooms(Room room);
}
