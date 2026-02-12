package ru.myproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myproject.config.MapperRoom;
import ru.myproject.dto.RequestRoom;
import ru.myproject.dto.ResponseRoom;
import ru.myproject.exeption.ConflictAlreadyRoom;
import ru.myproject.exeption.TransactionNotFoundExeption;
import ru.myproject.repository.RoomRepository;
import ru.myproject.service.ServiceRoom;
import ru.myproject.utill.MessageError;

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
        if (roomRepository.existsByNumber(requestRoom.number())){
            throw  new ConflictAlreadyRoom(MessageError.CONFLICT_ALREADY_ROOM);
        }
        var room = mapper.toConvertRequest(requestRoom);
        return mapper.toConvertResponse(roomRepository.save(room));
    }

    @Transactional
    @Override
    public ResponseRoom updateRoom(UUID id, RequestRoom requestRoom) {
        var room = roomRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundExeption("Такой комнаты нет."));

        if (room.getNumber() != requestRoom.number()  &&
                roomRepository.existsByNumber(requestRoom.number())) {
            throw new ConflictAlreadyRoom("Комната с номером " + requestRoom.number() + " уже существует");
        }

        mapper.updateRoomFromRequest(requestRoom, room);

        return mapper.toConvertResponse(roomRepository.save(room));
    }

    @Transactional
    @Override
    public List<ResponseRoom> getAllRooms() {
        return mapper.toConvertAllResponse(roomRepository.findAll());
    }

    @Transactional
    @Override
    public ResponseRoom getRoomId(UUID id) {
        var room = roomRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundExeption("Такой комнаты нет."));
        return mapper.toConvertResponse(room);
    }
}
