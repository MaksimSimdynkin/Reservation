package ru.myproject.service.impl;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.myproject.dto.RequestReservation;
import ru.myproject.dto.ResponseReservation;
import ru.myproject.service.ServiceReservation;

import java.util.UUID;

@Service
public class ServiceReservationImpl implements ServiceReservation {
    @Override
    public ResponseReservation getByReservation(UUID id) {
        return null;
    }

    @Override
    public ResponseReservation getAllReservation() {
        return null;
    }

    @Override
    public ResponseReservation createReservation(RequestReservation requestReservation) {
        return null;
    }

    @Override
    public ResponseReservation updateReservation(UUID id, RequestReservation requestReservation) {
        return null;
    }

    @Override
    public @Nullable Void deleteReservation(UUID id) {
        return null;
    }
}
