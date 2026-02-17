package ru.myproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.myproject.enums.StatusRoom;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    @ToString.Include
    private UUID roomId;

    @Column(name = "number", nullable = false)
    @ToString.Include
    private int number;

    @Column(name = "floor", nullable = false)
    @ToString.Include
    private int floor;

    @Column(name = "count_rooms", nullable = false)
    @ToString.Include
    private int countRooms;

    @Column(name = "count", nullable = false)
    @ToString.Include
    private int count;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_room", nullable = false)
    @ToString.Include
    private StatusRoom statusRoom;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @Builder
    public Room(int number, int floor, int countRooms, int count, StatusRoom statusRoom) {
        this.number = number;
        this.floor = floor;
        this.countRooms = countRooms;
        this.count = count;
        this.statusRoom = statusRoom;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o ) return true;
        if (o == null)  return false;

        if (Hibernate.getClass(this) != Hibernate.getClass(o)){
            return false;
        }
        Room room = (Room) o;

        return roomId != null && roomId.equals(room.roomId);
    }

    @Override
    public final int hashCode() {
        return Hibernate.getClass(this).hashCode();
    }
}
