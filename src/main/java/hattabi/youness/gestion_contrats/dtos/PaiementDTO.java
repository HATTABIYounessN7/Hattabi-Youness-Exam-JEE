package hattabi.youness.gestion_contrats.dtos;

import java.time.LocalDateTime;

import hattabi.youness.gestion_contrats.enums.TypePaiement;
import lombok.Data;

@Data
public class PaiementDTO {
    private Long id;

    private LocalDateTime date;
    private double montant;

    private TypePaiement typePaiement;
}
