package hattabi.youness.gestion_contrats.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppRole {
    @Id
    private String roleName; // ROLE_CLIENT, ROLE_EMPLOYE, ROLE_ADMIN
}
