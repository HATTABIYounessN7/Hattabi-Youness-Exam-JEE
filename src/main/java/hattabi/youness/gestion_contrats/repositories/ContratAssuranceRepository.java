package hattabi.youness.gestion_contrats.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hattabi.youness.gestion_contrats.entities.ContratAssurance;
import hattabi.youness.gestion_contrats.enums.StatutContrat;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, String> {
    List<ContratAssurance> findByClientId(Long clientId);

    List<ContratAssurance> findByStatut(StatutContrat statut);
}
