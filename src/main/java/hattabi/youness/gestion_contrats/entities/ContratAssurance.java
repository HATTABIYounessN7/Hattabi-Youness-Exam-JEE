package hattabi.youness.gestion_contrats.entities;

import hattabi.youness.gestion_contrats.enums.StatutContrat;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 3)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAssurance {
    @Id
    private String id;

    private LocalDateTime dateSouscription;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    private LocalDateTime dateValidation;
    private double montantCotisation;
    private Integer dureeContrat;
    private double tauxCouverture;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @OneToMany(mappedBy = "contratAssurance", fetch = FetchType.LAZY)
    private List<Paiement> paiements;
}
