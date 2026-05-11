package hattabi.youness.gestion_contrats.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hattabi.youness.gestion_contrats.dtos.ClientDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceAutomobileDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceHabitationDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceSanteDTO;
import hattabi.youness.gestion_contrats.dtos.PaiementDTO;
import hattabi.youness.gestion_contrats.entities.Client;
import hattabi.youness.gestion_contrats.entities.ContratAssurance;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceAutomobile;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceHabitation;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceSante;
import hattabi.youness.gestion_contrats.entities.Paiement;
import hattabi.youness.gestion_contrats.enums.StatutContrat;
import hattabi.youness.gestion_contrats.mappers.GestionCreditMapper;
import hattabi.youness.gestion_contrats.repositories.ClientRepository;
import hattabi.youness.gestion_contrats.repositories.ContratAssuranceRepository;
import hattabi.youness.gestion_contrats.repositories.PaiementRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ContratServiceImpl implements ContratService {
    private final ClientRepository clientRepository;
    private final ContratAssuranceRepository contratAssuranceRepository;
    private final PaiementRepository paiementRepository;
    private final GestionCreditMapper mapper;

    @Override
    public ClientDTO saveClient(ClientDTO dto) {
        Client client = mapper.fromClientDTO(dto);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client c = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found: " + id));
        return mapper.fromClient(c);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(mapper::fromClient).toList();
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client c = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found: " + id));
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        return mapper.fromClient(clientRepository.save(c));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> searchClients(String nom) {
        return clientRepository.searchCustomers("%" + nom + "%")
                .stream().map(mapper::fromClient).toList();
    }

    public ContratAssuranceAutomobileDTO saveContratAssuranceAutomobile(ContratAssuranceAutomobileDTO dto) {
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        ContratAssuranceAutomobile contratAssuranceAutomobile = new ContratAssuranceAutomobile();
        contratAssuranceAutomobile.setId(UUID.randomUUID().toString());
        contratAssuranceAutomobile.setDateSouscription(dto.getDateSouscription());
        contratAssuranceAutomobile.setStatut(dto.getStatut());
        contratAssuranceAutomobile.setDateValidation(dto.getDateValidation());
        contratAssuranceAutomobile.setMontantCotisation(dto.getMontantCotisation());
        contratAssuranceAutomobile.setDureeContrat(dto.getDureeContrat());
        contratAssuranceAutomobile.setTauxCouverture(dto.getTauxCouverture());
        contratAssuranceAutomobile.setClient(client);
        contratAssuranceAutomobile.setImmatriculation(dto.getImmatriculation());
        contratAssuranceAutomobile.setMarque(dto.getMarque());
        contratAssuranceAutomobile.setModele(dto.getModele());

        ContratAssuranceAutomobile saved = contratAssuranceRepository.save(contratAssuranceAutomobile);
        return mapper.fromContratAssuranceAutomobile(saved);
    }

    public ContratAssuranceHabitationDTO saveContratAssuranceHabitation(ContratAssuranceHabitationDTO dto) {
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        ContratAssuranceHabitation contratAssuranceHabitation = new ContratAssuranceHabitation();
        contratAssuranceHabitation.setId(UUID.randomUUID().toString());
        contratAssuranceHabitation.setDateSouscription(dto.getDateSouscription());
        contratAssuranceHabitation.setStatut(dto.getStatut());
        contratAssuranceHabitation.setDateValidation(dto.getDateValidation());
        contratAssuranceHabitation.setMontantCotisation(dto.getMontantCotisation());
        contratAssuranceHabitation.setDureeContrat(dto.getDureeContrat());
        contratAssuranceHabitation.setTauxCouverture(dto.getTauxCouverture());
        contratAssuranceHabitation.setClient(client);
        contratAssuranceHabitation.setTypeLogement(dto.getTypeLogement());
        contratAssuranceHabitation.setAdresse(dto.getAdresse());
        contratAssuranceHabitation.setSuperficie(dto.getSuperficie());

        ContratAssuranceHabitation saved = contratAssuranceRepository.save(contratAssuranceHabitation);
        return mapper.fromContratAssuranceHabitation(saved);
    }

    public ContratAssuranceSanteDTO savContratAssuranceSante(ContratAssuranceSanteDTO dto) {
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        ContratAssuranceSante contratAssuranceSante = new ContratAssuranceSante();
        contratAssuranceSante.setId(UUID.randomUUID().toString());
        contratAssuranceSante.setDateSouscription(dto.getDateSouscription());
        contratAssuranceSante.setStatut(dto.getStatut());
        contratAssuranceSante.setDateValidation(dto.getDateValidation());
        contratAssuranceSante.setMontantCotisation(dto.getMontantCotisation());
        contratAssuranceSante.setDureeContrat(dto.getDureeContrat());
        contratAssuranceSante.setTauxCouverture(dto.getTauxCouverture());
        contratAssuranceSante.setClient(client);
        contratAssuranceSante.setNiveauCouverture(dto.getNiveauCouverture());
        contratAssuranceSante.setNbPersonnesCouvertes(dto.getNbPersonnesCouvertes());

        ContratAssuranceSante saved = contratAssuranceRepository.save(contratAssuranceSante);
        return mapper.fromContratAssuranceSante(saved);
    }

    @Override
    public ContratAssuranceDTO getContrat(String id) {
        return mapper.fromContratAssurance(contratAssuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found: " + id)));
    }

    @Override
    public List<ContratAssuranceDTO> getAllContrats() {
        return contratAssuranceRepository.findAll().stream().map(mapper::fromContratAssurance).toList();
    }

    @Override
    public List<ContratAssuranceDTO> getContratsByClient(Long clientId) {
        return contratAssuranceRepository.findByClientId(clientId).stream().map(mapper::fromContratAssurance).toList();
    }

    @Override
    public List<ContratAssuranceDTO> getContratsByStatut(StatutContrat statut) {
        return contratAssuranceRepository.findByStatut(statut).stream().map(mapper::fromContratAssurance).toList();
    }

    @Override
    public ContratAssuranceDTO updateStatut(String id, StatutContrat statut) {
        ContratAssurance contratAssurance = contratAssuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found: " + id));
        contratAssurance.setStatut(statut);
        if (statut == StatutContrat.EN_COURS)
            contratAssurance.setDateValidation(LocalDateTime.now());
        return mapper.fromContratAssurance(contratAssuranceRepository.save(contratAssurance));
    }

    @Override
    public void deleteContrat(String id) {
        contratAssuranceRepository.deleteById(id);
    }

    @Override
    public PaiementDTO savePaiement(PaiementDTO dto) {
        ContratAssurance contratAssurance = contratAssuranceRepository.findById(dto.getContratId())
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        Paiement paiement = new Paiement();
        paiement.setDate(dto.getDate());
        paiement.setMontant(dto.getMontant());
        paiement.setTypePaiement(dto.getTypePaiement());
        paiement.setContratAssurance(contratAssurance);
        return mapper.fromPaiement(paiementRepository.save(paiement));
    }

    @Override
    public List<PaiementDTO> getPaiementsByContrat(String contratId) {
        return paiementRepository.findByContratAssuranceId(contratId)
                .stream().map(mapper::fromPaiement).toList();
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}
