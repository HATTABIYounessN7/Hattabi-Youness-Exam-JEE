package hattabi.youness.gestion_contrats.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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

@Component
public class GestionCreditMapper {
    public ClientDTO fromClient(Client Client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(Client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO ClientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(ClientDTO, client);
        return client;
    }

    public ContratAssuranceAutomobileDTO fromContratAssuranceAutomobile(
            ContratAssuranceAutomobile contratAssuranceAutomobile) {
        ContratAssuranceAutomobileDTO contratAssuranceAutomobileDTO = new ContratAssuranceAutomobileDTO();
        BeanUtils.copyProperties(contratAssuranceAutomobile, contratAssuranceAutomobileDTO);
        contratAssuranceAutomobileDTO.setClientDTO(fromClient(contratAssuranceAutomobile.getClient()));
        contratAssuranceAutomobileDTO.setType(contratAssuranceAutomobile.getClass().getSimpleName());
        return contratAssuranceAutomobileDTO;
    }

    public ContratAssuranceAutomobile fromContratAssuranceAutomobileDTO(
            ContratAssuranceAutomobileDTO contratAssuranceAutomobileDTO) {
        ContratAssuranceAutomobile contratAssuranceAutomobile = new ContratAssuranceAutomobile();
        BeanUtils.copyProperties(contratAssuranceAutomobileDTO, contratAssuranceAutomobile);
        contratAssuranceAutomobile.setClient(fromClientDTO(contratAssuranceAutomobileDTO.getClientDTO()));
        contratAssuranceAutomobile.setStatut(
                contratAssuranceAutomobileDTO.getStatut() != null ? contratAssuranceAutomobileDTO.getStatut()
                        : StatutContrat.EN_COURS);
        return contratAssuranceAutomobile;
    }

    public ContratAssuranceHabitationDTO fromContratAssuranceHabitation(
            ContratAssuranceHabitation contratAssuranceHabitation) {
        ContratAssuranceHabitationDTO contratAssuranceHabitationDTO = new ContratAssuranceHabitationDTO();
        BeanUtils.copyProperties(contratAssuranceHabitation, contratAssuranceHabitationDTO);
        contratAssuranceHabitationDTO.setClientDTO(fromClient(contratAssuranceHabitation.getClient()));
        contratAssuranceHabitationDTO.setType(contratAssuranceHabitation.getClass().getSimpleName());
        return contratAssuranceHabitationDTO;
    }

    public ContratAssuranceHabitation fromContratAssuranceHabitationDTO(
            ContratAssuranceHabitationDTO contratAssuranceHabitationDTO) {
        ContratAssuranceHabitation ContratAssuranceHabitation = new ContratAssuranceHabitation();
        BeanUtils.copyProperties(contratAssuranceHabitationDTO, ContratAssuranceHabitation);
        ContratAssuranceHabitation.setClient(fromClientDTO(contratAssuranceHabitationDTO.getClientDTO()));
        ContratAssuranceHabitation.setStatut(
                contratAssuranceHabitationDTO.getStatut() != null ? contratAssuranceHabitationDTO.getStatut()
                        : StatutContrat.EN_COURS);
        return ContratAssuranceHabitation;
    }

    public ContratAssuranceSanteDTO fromContratAssuranceSante(ContratAssuranceSante contratAssuranceSante) {
        ContratAssuranceSanteDTO contratAssuranceSanteDTO = new ContratAssuranceSanteDTO();
        BeanUtils.copyProperties(contratAssuranceSante, contratAssuranceSanteDTO);
        contratAssuranceSanteDTO.setClientDTO(fromClient(contratAssuranceSante.getClient()));
        contratAssuranceSanteDTO.setType(contratAssuranceSante.getClass().getSimpleName());
        return contratAssuranceSanteDTO;
    }

    public ContratAssuranceSante fromContratAssuranceSanteDTO(ContratAssuranceSanteDTO contratAssuranceSanteDTO) {
        ContratAssuranceSante contratAssuranceSante = new ContratAssuranceSante();
        BeanUtils.copyProperties(contratAssuranceSanteDTO, contratAssuranceSante);
        contratAssuranceSante.setClient(fromClientDTO(contratAssuranceSanteDTO.getClientDTO()));
        contratAssuranceSante.setStatut(
                contratAssuranceSanteDTO.getStatut() != null ? contratAssuranceSanteDTO.getStatut()
                        : StatutContrat.EN_COURS);
        return contratAssuranceSante;
    }

    public PaiementDTO fromPaiement(Paiement paiement) {
        PaiementDTO paiementDTO = new PaiementDTO();
        BeanUtils.copyProperties(paiement, paiementDTO);
        return paiementDTO;
    }

    public ContratAssuranceDTO fromContratAssurance(ContratAssurance contratAssurance) {
        if (contratAssurance instanceof ContratAssuranceAutomobile contratAssuranceAutomobile) {
            return fromContratAssuranceAutomobile(contratAssuranceAutomobile);
        } else if (contratAssurance instanceof ContratAssuranceHabitation contratAssuranceHabitation) {
            return fromContratAssuranceHabitation(contratAssuranceHabitation);
        } else if (contratAssurance instanceof ContratAssuranceSante contratAssuranceSante) {
            return fromContratAssuranceSante(contratAssuranceSante);
        }

        throw new IllegalArgumentException(
                "Unknown Bank Account Type : " + contratAssurance.getClass().getSimpleName());
    }
}
