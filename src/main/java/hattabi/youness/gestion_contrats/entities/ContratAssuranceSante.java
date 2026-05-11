package hattabi.youness.gestion_contrats.entities;

import hattabi.youness.gestion_contrats.enums.NiveauCouverture;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CAS")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContratAssuranceSante extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private Integer nbPersonnesCouvertes;
}
