package ru.myproject.service.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myproject.config.AuthUtil;
import ru.myproject.dto.AuthenticationRequest;
import ru.myproject.dto.AuthenticationResponse;
import ru.myproject.dto.RegisterRequest;
import ru.myproject.dto.RegisterResponse;
import ru.myproject.entity.AppUsers;
import ru.myproject.entity.User;
import ru.myproject.enums.RoleAppUsers;
import ru.myproject.exeption.ConflictRegisterException;
import ru.myproject.repository.RepositoryAppUsers;
import ru.myproject.service.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final RepositoryAppUsers repositoryAppUsers;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        var users = repositoryAppUsers.findByEmail(request.email()).orElse(null);

        if (users != null){
            throw new ConflictRegisterException("Пользователь с таким email уже зарегистрирован");
        }

        AppUsers appUsers = AppUsers.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(RoleAppUsers.DEFAULT)
                .build();

        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phone(request.phone())
                .age(request.age())
                .build();
        appUsers.setProfile(user);
        repositoryAppUsers.save(appUsers);

        String token = authUtil.generateAccessToken(appUsers);

        return RegisterResponse.builder()
                .email(appUsers.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
            AppUsers users = (AppUsers) authenticate.getPrincipal(); // нужно ли проводить проверку есть пользователь или нет ??

            String jwt = authUtil.generateAccessToken(users);

            return AuthenticationResponse.builder()
                    .email(users.getUsername())
                    .token(jwt)
                    .build();

    }
}
