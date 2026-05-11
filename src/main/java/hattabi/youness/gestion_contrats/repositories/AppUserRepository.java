package hattabi.youness.gestion_contrats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hattabi.youness.gestion_contrats.entities.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}