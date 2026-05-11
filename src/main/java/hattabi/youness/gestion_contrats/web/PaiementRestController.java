package hattabi.youness.gestion_contrats.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import hattabi.youness.gestion_contrats.dtos.PaiementDTO;
import hattabi.youness.gestion_contrats.services.ContratService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementRestController {
    private final ContratService contratService;

    @GetMapping("/credit/{creditId}")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public List<PaiementDTO> getByContrat(@PathVariable String creditId) {
        return contratService.getPaiementsByContrat(creditId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<PaiementDTO> create(@RequestBody PaiementDTO dto) {
        return ResponseEntity.ok(contratService.savePaiement(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
