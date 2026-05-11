package hattabi.youness.gestion_contrats.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import hattabi.youness.gestion_contrats.enums.TypePaiement;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private LocalDateTime date;
    private double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContratAssurance contratAssurance;
}
