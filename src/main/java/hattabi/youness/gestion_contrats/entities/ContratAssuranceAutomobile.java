package hattabi.youness.gestion_contrats.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CAA")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContratAssuranceAutomobile extends ContratAssurance {
    private String immatriculation;
    private String marque;
    private String modele;
}
