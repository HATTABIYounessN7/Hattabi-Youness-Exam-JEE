package hattabi.youness.gestion_contrats.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import hattabi.youness.gestion_contrats.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratAssuranceId(String contratAssuranceId);

    Page<Paiement> findByContratAssuranceId(String contratAssuranceId, Pageable pageable);
}