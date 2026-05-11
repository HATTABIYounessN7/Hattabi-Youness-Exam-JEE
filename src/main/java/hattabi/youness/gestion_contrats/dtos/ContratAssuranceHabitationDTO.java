package hattabi.youness.gestion_contrats.dtos;

import java.time.LocalDateTime;

import hattabi.youness.gestion_contrats.enums.StatutContrat;
import hattabi.youness.gestion_contrats.enums.TypeLogement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContratAssuranceHabitationDTO extends ContratAssuranceDTO {
    private String id;
    private LocalDateTime dateSouscription;
    private StatutContrat statut;
    private LocalDateTime dateValidation;
    private double montantCotisation;
    private Integer dureeContrat;
    private double tauxCouverture;
    private ClientDTO clientDTO;
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
