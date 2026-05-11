package hattabi.youness.gestion_contrats.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hattabi.youness.gestion_contrats.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE :kw")
    List<Client> searchCustomers(@Param("kw") String keyword);
}
