package ru.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myproject.dto.RequestReservation;
import ru.myproject.dto.ResponseReservation;
import ru.myproject.service.ServiceReservation;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abs/v1/reservation")
public class ControllerReservation {

    private final ServiceReservation serviceReservation;

    @GetMapping("/id")
    public ResponseEntity<ResponseReservation> getReservationId(@PathVariable("id") UUID id){
        return ResponseEntity.ok(serviceReservation.getByReservation(id));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseReservation> getAllReservation(){
        return ResponseEntity.ok(serviceReservation.getAllReservation());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseReservation> createReservation(@RequestBody RequestReservation requestReservation){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceReservation.createReservation(requestReservation));
    }

    @PostMapping("/id")
    public ResponseEntity<ResponseReservation> updateReservation(@PathVariable("id") UUID id, @RequestBody RequestReservation requestReservation){
        return ResponseEntity.ok(serviceReservation.updateReservation(id, requestReservation));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") UUID id){
        return ResponseEntity.ok(serviceReservation.deleteReservation(id));
    }

}
