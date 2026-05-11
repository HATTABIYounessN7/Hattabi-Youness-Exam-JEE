package hattabi.youness.gestion_contrats.web;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import hattabi.youness.gestion_contrats.dtos.ContratAssuranceAutomobileDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceHabitationDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceSanteDTO;
import hattabi.youness.gestion_contrats.enums.StatutContrat;
import hattabi.youness.gestion_contrats.services.ContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratAssuranceRestController {
    private final ContratService contratService;

    @GetMapping
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ContratAssuranceDTO> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAssuranceDTO> getContrat(@PathVariable String id) {
        return ResponseEntity.ok(contratService.getContrat(id));
    }

    @GetMapping("/client/{clientId}")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public List<ContratAssuranceDTO> getContratsByClient(@PathVariable Long clientId) {
        return contratService.getContratsByClient(clientId);
    }

    @GetMapping("/statut/{statut}")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ContratAssuranceDTO> getContratsByStatut(@PathVariable StatutContrat statut) {
        return contratService.getContratsByStatut(statut);
    }

    @PostMapping("/automobile")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAssuranceDTO> createAutomobile(@RequestBody ContratAssuranceAutomobileDTO dto) {
        return ResponseEntity.ok(contratService.saveContratAssuranceAutomobile(dto));
    }

    @PostMapping("/habitation")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAssuranceDTO> createHabitation(@RequestBody ContratAssuranceHabitationDTO dto) {
        return ResponseEntity.ok(contratService.saveContratAssuranceHabitation(dto));
    }

    @PostMapping("/sante")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAssuranceDTO> createSante(@RequestBody ContratAssuranceSanteDTO dto) {
        return ResponseEntity.ok(contratService.savContratAssuranceSante(dto));
    }

    @PatchMapping("/{id}/statut")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public ResponseEntity<ContratAssuranceDTO> updateStatut(@PathVariable String id,
            @RequestParam StatutContrat statut) {
        return ResponseEntity.ok(contratService.updateStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteContrat(@PathVariable String id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
