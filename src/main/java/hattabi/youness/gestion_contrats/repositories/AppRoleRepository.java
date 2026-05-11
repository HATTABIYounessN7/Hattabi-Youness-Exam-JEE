package hattabi.youness.gestion_contrats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hattabi.youness.gestion_contrats.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}