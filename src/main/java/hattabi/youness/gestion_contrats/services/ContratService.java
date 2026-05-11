package hattabi.youness.gestion_contrats.services;

import hattabi.youness.gestion_contrats.dtos.ClientDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceAutomobileDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceHabitationDTO;
import hattabi.youness.gestion_contrats.dtos.ContratAssuranceSanteDTO;
import hattabi.youness.gestion_contrats.dtos.PaiementDTO;
import hattabi.youness.gestion_contrats.enums.StatutContrat;

import java.util.List;

public interface ContratService {
    ClientDTO saveClient(ClientDTO dto);

    ClientDTO getClient(Long id);

    List<ClientDTO> getAllClients();

    ClientDTO updateClient(Long id, ClientDTO dto);

    void deleteClient(Long id);

    List<ClientDTO> searchClients(String nom);

    ContratAssuranceAutomobileDTO saveContratAssuranceAutomobile(ContratAssuranceAutomobileDTO dto);

    ContratAssuranceHabitationDTO saveContratAssuranceHabitation(ContratAssuranceHabitationDTO dto);

    ContratAssuranceSanteDTO savContratAssuranceSante(ContratAssuranceSanteDTO dto);

    ContratAssuranceDTO getContrat(String id);

    List<ContratAssuranceDTO> getAllContrats();

    List<ContratAssuranceDTO> getContratsByClient(Long clientId);

    List<ContratAssuranceDTO> getContratsByStatut(StatutContrat statut);

    ContratAssuranceDTO updateStatut(String id, StatutContrat statut);

    void deleteContrat(String id);

    PaiementDTO savePaiement(PaiementDTO dto);

    List<PaiementDTO> getPaiementsByContrat(String contratId);

    void deletePaiement(Long id);
}
