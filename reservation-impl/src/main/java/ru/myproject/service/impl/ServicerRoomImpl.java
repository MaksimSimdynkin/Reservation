package ru.myproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myproject.config.MapperRoom;
import ru.myproject.dto.RequestRoom;
import ru.myproject.dto.ResponseRoom;
import ru.myproject.repository.RoomRepository;
import ru.myproject.service.ServiceRoom;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicerRoomImpl implements ServiceRoom {

    private final RoomRepository roomRepository;
    private final MapperRoom mapper;

    @Transactional
    @Override
    public ResponseRoom createRooms(RequestRoom requestRoom) {
        var room = mapper.toConvertRequest(requestRoom);
        return mapper.toConvertResponse(roomRepository.save(room));
    }

    @Override
    public ResponseRoom updateRoom(UUID id, RequestRoom requestRoom) {
        return null;
    }

    @Override
    public List<ResponseRoom> getAllRooms() {
        return mapper.toConvertAllResponse(roomRepository.findAll());
    }
}
