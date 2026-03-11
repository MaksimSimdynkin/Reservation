package ru.myproject.service;

import org.springframework.http.ResponseEntity;
import ru.myproject.dto.AuthenticationRequest;
import ru.myproject.dto.AuthenticationResponse;
import ru.myproject.dto.RegisterRequest;
import ru.myproject.dto.RegisterResponse;

public interface AuthenticationService {


    RegisterResponse register(RegisterRequest request);

    AuthenticationResponse authentication(AuthenticationRequest request);
}
