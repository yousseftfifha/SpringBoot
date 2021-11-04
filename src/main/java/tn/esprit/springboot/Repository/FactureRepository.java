package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
