package ru.myproject.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import ru.myproject.Room;
import ru.myproject.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ResponseReservation(
        UUID id,
        String name,
        Room room,
        LocalDateTime firstDate,
        LocalDateTime lastDate
) {
}
