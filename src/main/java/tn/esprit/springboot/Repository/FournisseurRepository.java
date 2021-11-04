package tn.esprit.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springboot.Entities.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
