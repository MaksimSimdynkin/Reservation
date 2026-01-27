package ru.myproject.service;

import org.jspecify.annotations.Nullable;
import ru.myproject.dto.RequestReservation;
import ru.myproject.dto.ResponseReservation;

import java.util.UUID;

public interface ServiceReservation {

    ResponseReservation getByReservation(UUID id);

    ResponseReservation getAllReservation();

    ResponseReservation createReservation(RequestReservation requestReservation);

    ResponseReservation updateReservation(UUID id, RequestReservation requestReservation);

    @Nullable Void deleteReservation(UUID id);

}
