package hattabi.youness.gestion_contrats.entities;

import hattabi.youness.gestion_contrats.enums.TypeLogement;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CAH")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContratAssuranceHabitation extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
