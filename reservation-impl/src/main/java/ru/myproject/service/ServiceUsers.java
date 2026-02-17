package ru.myproject.service;

import ru.myproject.dto.RequestUsers;
import ru.myproject.dto.ResponseUsers;

public interface ServiceUsers {

    ResponseUsers getProfile();

    ResponseUsers updateProfile(RequestUsers requestUsers);

    Void deleteProfile();

}
