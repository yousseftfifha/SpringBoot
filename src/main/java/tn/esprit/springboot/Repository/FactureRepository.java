package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Entities.Facture;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {

    @Query("select f  from Facture  f WHERE f.active=true and f.client=:Client")
    List<Facture> getFactureByClient(@Param("Client") Client client);
}
