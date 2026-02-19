package ru.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myproject.dto.RequestUsers;
import ru.myproject.dto.ResponseUsers;
import ru.myproject.service.ServiceUsers;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/abs/v1/users")
@RequiredArgsConstructor
public class ControllerProfileUsers {

    private ServiceUsers serviceUsers;

    @GetMapping()
    public ResponseEntity<ResponseUsers> getProfile(){
        return ResponseEntity.ok(serviceUsers.getProfile());
    }

    @PostMapping("/updateProfile")
    public ResponseEntity<ResponseUsers> updateProfileUsers(@RequestBody RequestUsers requestUsers){
        return ResponseEntity.ok(serviceUsers.updateProfile(requestUsers));
    }

    @DeleteMapping("/delete")
    public Void deleteProfile(){
        return serviceUsers.deleteProfile();
    }

}
