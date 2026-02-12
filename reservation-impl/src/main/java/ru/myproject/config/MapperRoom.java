package ru.myproject.config;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.myproject.dto.RequestRoom;
import ru.myproject.dto.ResponseRoom;
import ru.myproject.entity.Room;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperRoom {


    Room toConvertRequest(RequestRoom requestRoom);

    ResponseRoom toConvertResponse(Room room);

    List<ResponseRoom> toConvertAllResponse(List<Room> room);

    void updateRoomFromRequest(RequestRoom requestRoom, @MappingTarget Room room);

}
