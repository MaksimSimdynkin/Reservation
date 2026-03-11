package ru.myproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {


    @Id
    @Column(name = "user_id")
    private Long id;

    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private AppUsers appUsers;

    @Column(name = "first_name", nullable = false)
    @ToString.Include
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ToString.Include
    private String lastName;

    @Column(name = "phone", nullable = false)
    @ToString.Include
    private String phone;

    @Column(name = "age", nullable = false)
    @ToString.Include
    private int age;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Reservation> reservations;

    public void setAppUsers(AppUsers appUsers){
        this.appUsers = appUsers;
        if (appUsers != null && appUsers.getProfile() != this){
            appUsers.setProfile(this);
        }
    }

    @Builder
    public User(String firstName, String lastName, String phone, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public final boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (Hibernate.getClass(this) != Hibernate.getClass(o)){
            return false;
        }

        User user =(User) o;
        return id != null && id.equals(user.id);
    }

    @Override
    public final int hashCode() {
        return Hibernate.getClass(this).hashCode();
    }
}
