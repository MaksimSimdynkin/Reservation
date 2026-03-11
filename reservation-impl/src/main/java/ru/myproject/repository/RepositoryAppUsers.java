package ru.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myproject.entity.AppUsers;

import java.util.Optional;

public interface RepositoryAppUsers extends JpaRepository<AppUsers, Long> {

    Optional<AppUsers> findByEmail(String email);
}
