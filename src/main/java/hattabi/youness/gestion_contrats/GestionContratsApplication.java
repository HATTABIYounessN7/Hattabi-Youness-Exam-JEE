package hattabi.youness.gestion_contrats;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hattabi.youness.gestion_contrats.entities.Client;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceAutomobile;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceHabitation;
import hattabi.youness.gestion_contrats.entities.ContratAssuranceSante;
import hattabi.youness.gestion_contrats.entities.Paiement;
import hattabi.youness.gestion_contrats.enums.NiveauCouverture;
import hattabi.youness.gestion_contrats.enums.StatutContrat;
import hattabi.youness.gestion_contrats.enums.TypeLogement;
import hattabi.youness.gestion_contrats.enums.TypePaiement;
import hattabi.youness.gestion_contrats.repositories.ClientRepository;
import hattabi.youness.gestion_contrats.repositories.ContratAssuranceRepository;
import hattabi.youness.gestion_contrats.repositories.PaiementRepository;

@SpringBootApplication
public class GestionContratsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionContratsApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(ClientRepository clientRepository, ContratAssuranceRepository contratAssuranceRepository,
            PaiementRepository paiementRepository) {
        return args -> {

            // ===================== CLIENTS =====================
            Client client1 = new Client();
            client1.setName("Ahmed Benali");
            client1.setEmail("ahmed.benali@email.ma");

            Client client2 = new Client();
            client2.setName("Fatima Zahra Idrissi");
            client2.setEmail("fz.idrissi@email.ma");

            Client client3 = new Client();
            client3.setName("Youssef El Amrani");
            client3.setEmail("y.elamrani@email.ma");

            clientRepository.saveAll(List.of(client1, client2, client3));

            // ============= CONTRATS AUTOMOBILE =============
            ContratAssuranceAutomobile contratAuto1 = new ContratAssuranceAutomobile();
            contratAuto1.setId(UUID.randomUUID().toString());
            contratAuto1.setDateSouscription(LocalDateTime.of(2023, 3, 15, 12, 55));
            contratAuto1.setStatut(StatutContrat.VALIDE);
            contratAuto1.setDateValidation(LocalDateTime.of(2023, 3, 20, 12, 55));
            contratAuto1.setMontantCotisation(1200.0);
            contratAuto1.setDureeContrat(12);
            contratAuto1.setTauxCouverture(80.0);
            contratAuto1.setImmatriculation("12345-A-6");
            contratAuto1.setMarque("Dacia");
            contratAuto1.setModele("Logan");
            contratAuto1.setClient(client1);

            ContratAssuranceAutomobile contratAuto2 = new ContratAssuranceAutomobile();
            contratAuto2.setId(UUID.randomUUID().toString());
            contratAuto2.setDateSouscription(LocalDateTime.of(2024, 1, 10, 12, 55));
            contratAuto2.setStatut(StatutContrat.EN_COURS);
            contratAuto2.setMontantCotisation(1800.0);
            contratAuto2.setDureeContrat(24);
            contratAuto2.setTauxCouverture(90.0);
            contratAuto2.setImmatriculation("67890-B-7");
            contratAuto2.setMarque("Renault");
            contratAuto2.setModele("Clio");
            contratAuto2.setClient(client2);

            contratAssuranceRepository.saveAll(List.of(contratAuto1, contratAuto2));

            // ============= CONTRATS HABITATION =============
            ContratAssuranceHabitation contratHab1 = new ContratAssuranceHabitation();
            contratHab1.setId(UUID.randomUUID().toString());
            contratHab1.setDateSouscription(LocalDateTime.of(2022, 6, 1, 12, 55));
            contratHab1.setStatut(StatutContrat.VALIDE);
            contratHab1.setDateValidation(LocalDateTime.of(2022, 6, 5, 12, 55));
            contratHab1.setMontantCotisation(950.0);
            contratHab1.setDureeContrat(12);
            contratHab1.setTauxCouverture(75.0);
            contratHab1.setTypeLogement(TypeLogement.APPARTEMENT);
            contratHab1.setAdresse("Rue des Fleurs, Casablanca");
            contratHab1.setSuperficie(85.0);
            contratHab1.setClient(client1);

            ContratAssuranceHabitation contratHab2 = new ContratAssuranceHabitation();
            contratHab2.setId(UUID.randomUUID().toString());
            contratHab2.setDateSouscription(LocalDateTime.of(2023, 11, 20, 12, 55));
            contratHab2.setStatut(StatutContrat.EN_COURS);
            contratHab2.setMontantCotisation(1500.0);
            contratHab2.setDureeContrat(36);
            contratHab2.setTauxCouverture(85.0);
            contratHab2.setTypeLogement(TypeLogement.MAISON);
            contratHab2.setAdresse("Avenue Mohammed V, Rabat");
            contratHab2.setSuperficie(200.0);
            contratHab2.setClient(client3);

            contratAssuranceRepository.saveAll(List.of(contratHab1, contratHab2));

            // ============= CONTRATS SANTE =============
            ContratAssuranceSante contratSante1 = new ContratAssuranceSante();
            contratSante1.setId(UUID.randomUUID().toString());
            contratSante1.setDateSouscription(LocalDateTime.of(2023, 1, 1, 12, 55));
            contratSante1.setStatut(StatutContrat.VALIDE);
            contratSante1.setDateValidation(LocalDateTime.of(2023, 1, 3, 12, 55));
            contratSante1.setMontantCotisation(2400.0);
            contratSante1.setDureeContrat(12);
            contratSante1.setTauxCouverture(95.0);
            contratSante1.setNiveauCouverture(NiveauCouverture.PREMIUM);
            contratSante1.setNbPersonnesCouvertes(4);
            contratSante1.setClient(client2);

            ContratAssuranceSante contratSante2 = new ContratAssuranceSante();
            contratSante2.setId(UUID.randomUUID().toString());
            contratSante2.setDateSouscription(LocalDateTime.of(2024, 4, 15, 12, 55));
            contratSante2.setStatut(StatutContrat.RESILIE);
            contratSante2.setDateValidation(LocalDateTime.of(2024, 4, 20, 12, 55));
            contratSante2.setMontantCotisation(700.0);
            contratSante2.setDureeContrat(6);
            contratSante2.setTauxCouverture(60.0);
            contratSante2.setNiveauCouverture(NiveauCouverture.BASIQUE);
            contratSante2.setNbPersonnesCouvertes(1);
            contratSante2.setClient(client3);

            contratAssuranceRepository.saveAll(List.of(contratSante1, contratSante2));

            // ===================== PAIEMENTS =====================
            Paiement p1 = new Paiement();
            p1.setDate(LocalDateTime.of(2023, 3, 20, 12, 55));
            p1.setMontant(1200.0);
            p1.setTypePaiement(TypePaiement.PAIEMENT_ANNUEL);
            p1.setContratAssurance(contratAuto1);

            Paiement p2 = new Paiement();
            p2.setDate(LocalDateTime.of(2024, 1, 10, 12, 55));
            p2.setMontant(150.0);
            p2.setTypePaiement(TypePaiement.MENSUALITE);
            p2.setContratAssurance(contratAuto2);

            Paiement p3 = new Paiement();
            p3.setDate(LocalDateTime.of(2024, 2, 10, 12, 55));
            p3.setMontant(150.0);
            p3.setTypePaiement(TypePaiement.MENSUALITE);
            p3.setContratAssurance(contratAuto2);

            Paiement p4 = new Paiement();
            p4.setDate(LocalDateTime.of(2022, 6, 5, 12, 55));
            p4.setMontant(950.0);
            p4.setTypePaiement(TypePaiement.PAIEMENT_ANNUEL);
            p4.setContratAssurance(contratHab1);

            Paiement p5 = new Paiement();
            p5.setDate(LocalDateTime.of(2023, 1, 3, 12, 55));
            p5.setMontant(200.0);
            p5.setTypePaiement(TypePaiement.MENSUALITE);
            p5.setContratAssurance(contratSante1);

            Paiement p6 = new Paiement();
            p6.setDate(LocalDateTime.of(2023, 5, 10, 12, 55));
            p6.setMontant(500.0);
            p6.setTypePaiement(TypePaiement.PAIEMENT_EXCEPTIONNEL);
            p6.setContratAssurance(contratSante1);

            paiementRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6));

            System.out.println("=== Base de données initialisée avec succès ===");
            System.out.println("Clients : " + clientRepository.count());
            System.out.println("Contrats : " + contratAssuranceRepository.count());
            System.out.println("Paiements : " + paiementRepository.count());
        };
    }
}
