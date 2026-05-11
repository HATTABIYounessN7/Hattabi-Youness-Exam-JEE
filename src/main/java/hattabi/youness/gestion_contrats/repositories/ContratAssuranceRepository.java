package hattabi.youness.gestion_contrats.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hattabi.youness.gestion_contrats.entities.ContratAssurance;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, String> {
    List<ContratAssurance> findByClientId(Long clientId);
}
