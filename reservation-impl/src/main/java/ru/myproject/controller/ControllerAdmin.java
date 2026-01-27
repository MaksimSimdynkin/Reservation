package ru.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myproject.dto.RequestRoom;
import ru.myproject.service.ServiceRoom;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abs/v1/admin")
public class ControllerAdmin {

    private final ServiceRoom serviceRoom;

    @GetMapping("/addRoom")
    public ResponseEntity<Void> addRoom(@RequestBody RequestRoom requestRoom){
        return ResponseEntity.ok(serviceRoom.addRooms(requestRoom));
    }
}
