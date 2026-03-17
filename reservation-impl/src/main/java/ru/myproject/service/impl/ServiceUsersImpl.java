package ru.myproject.service.impl;

import org.springframework.stereotype.Service;
import ru.myproject.dto.RequestUsers;
import ru.myproject.dto.ResponseUsers;
import ru.myproject.service.ServiceUsers;

@Service
public class ServiceUsersImpl implements ServiceUsers {
    @Override
    public ResponseUsers getProfile() {
        return null;
    }

    @Override
    public ResponseUsers updateProfile(RequestUsers requestUsers) {
        return null;
    }

    @Override
    public Void deleteProfile() {
        return null;
    }
}
