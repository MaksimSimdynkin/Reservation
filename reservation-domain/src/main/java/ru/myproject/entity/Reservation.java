package ru.myproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.myproject.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ToString.Include
    @Column(name = "reservation_id")
    private UUID reservationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false, updatable = false)
    private Room room;

    @Column(name = "first_date", nullable = false)
    @ToString.Include
    private LocalDateTime firstDate;

    @Column(name = "last_date", nullable = false)
    @ToString.Include
    private LocalDateTime lastDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @ToString.Include
    private ReservationStatus status;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    @ToString.Include(name = "userId")
    private UUID userIdToString(){
        return user!= null ? user.getUserId() : null;
    }

    @ToString.Include(name = "roomId")
    private UUID roomIdToString(){
        return room != null ? room.getRoomId() : null;
    }


    @Builder
    public Reservation(User user, Room room, LocalDateTime firstDate, LocalDateTime lastDate, ReservationStatus status) {
        this.user = user;
        this.room = room;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.status = status;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)){
            return false;
        }
        Reservation reservation = (Reservation) o;

        return reservationId != null && reservationId.equals(reservation.reservationId);
    }

    @Override
    public final int hashCode() {
        return Hibernate.getClass(this).hashCode();
    }
}
