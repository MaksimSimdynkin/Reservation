package ru.myproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myproject.dto.AuthenticationRequest;
import ru.myproject.dto.AuthenticationResponse;
import ru.myproject.dto.RegisterRequest;
import ru.myproject.dto.RegisterResponse;
import ru.myproject.service.AuthenticationService;

@RestController
@RequestMapping("/abs/v1/auth")
@RequiredArgsConstructor
public class ControllerAuthentication {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authentication(request));
    }
}
