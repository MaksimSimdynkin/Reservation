package ru.myproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myproject.dto.RequestRoom;
import ru.myproject.dto.ResponseRoom;
import ru.myproject.service.ServiceRoom;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abs/v1/admin/rooms")
@Validated
public class ControllerAdmin {

    private final ServiceRoom serviceRoom;

    @PostMapping("/addRooms")
    public ResponseEntity<ResponseRoom> addRoom(@RequestBody @Valid RequestRoom requestRoom){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceRoom.createRooms(requestRoom));
    }

    @PutMapping("/updateRoom/{id}")
    public ResponseEntity<ResponseRoom> updateRoom(@PathVariable("id") UUID id,
                                                   @RequestBody @Valid RequestRoom requestRoom){
        return ResponseEntity.ok(serviceRoom.updateRoom(id, requestRoom));
    }
}
