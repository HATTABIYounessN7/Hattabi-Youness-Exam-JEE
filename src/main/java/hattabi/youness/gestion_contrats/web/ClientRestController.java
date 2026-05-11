package hattabi.youness.gestion_contrats.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import hattabi.youness.gestion_contrats.dtos.ClientDTO;
import hattabi.youness.gestion_contrats.services.ContratService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientRestController {

    private final ContratService contratService;

    @GetMapping
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ClientDTO> getAllClients() {
        return contratService.getAllClients();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT','EMPLOYE','ADMIN')")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getClient(id));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('EMPLOYE','ADMIN')")
    public List<ClientDTO> searchClients(@RequestParam String nom) {
        return contratService.searchClients(nom);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(contratService.saveClient(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(contratService.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        contratService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}