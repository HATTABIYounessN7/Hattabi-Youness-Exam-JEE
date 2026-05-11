package hattabi.youness.gestion_contrats.dtos;

import java.time.LocalDateTime;

import hattabi.youness.gestion_contrats.enums.StatutContrat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContratAssuranceAutomobileDTO extends ContratAssuranceDTO {
    private String id;
    private LocalDateTime dateSouscription;
    private StatutContrat statut;
    private LocalDateTime dateValidation;
    private double montantCotisation;
    private Integer dureeContrat;
    private double tauxCouverture;
    private ClientDTO clientDTO;
    private String immatriculation;
    private String marque;
    private String modele;
}
