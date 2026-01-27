package ru.myproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.myproject.enums.StatusRoom;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    private UUID roomId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "count_rooms")
    private Integer countRooms;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_room")
    private StatusRoom statusRoom;

    @OneToOne(mappedBy = "room")
    private Reservation reservation;
}
